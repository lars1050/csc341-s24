
/** Collection of functions to transform a user-entered password into
 * a hashed password. One might say it is encrypted, but technically, encryption refers
 * to when one can reverse the process and get the original password from the encrypted.
 * Whereas, if a password is hashed, the process cannot be reversed to retrieve the original.
 * 
 * "Salting" a password is adding characters to it to make them all uniform length.
 * The salted password and key (typically a very long series of characters) are combined to
 * produce the hashed password.
 * 
 * I made up this particular way of salting and hashing. It isn't secure, but you get the idea.
 */
public class Hasher {

    // in case you want to turn printing on and off
    private static final boolean debug = false;

    // hash maps for converting between hexidecimal and decimal
    //private static Converters converters = new Converters();
    
    /** Salt string to create fixed length password */
    private String salt = "";    // initialized in constructor
    
    /** Encryption key used to hash user-entered password */
    private String key = "";    // initialized in constructor
    
    /** Create new hasher with given salt and key strings.
    * @param salt string to create fixed-length passwords
    * @param key string with which to hash salted password
    */
    public Hasher(String salt, String key) {
    	this.salt = salt;
    	this.key = key;
    }

    /** Transform a password into a fixed length string.
     * 
     * @param password user-entered password
     * @param salt unique series of characters used to pad the password
     * @return salted password
     */
    private String salt(String password) {

        // characters needed to create fixed-length password
        int needed = salt.length() - password.length();

        // salt is added to the end of the password
        return password + salt.substring(0,needed);
    }

    /** Transform character (ascii) string to hex equivalent string with 2 hex per ascii char.
     * @param asciiString Visible ascii characters
     * @return string with 2 hex digits ('0' to 'f') per ascii char
     */
    private String hexify(String asciiString) {
        // start with an empty string and append hex values
        String hexed = "";
        for (int i=0; i<asciiString.length(); i++) {
            // using built-in function to convert from ascii to hex
            hexed += Integer.toHexString(asciiString.charAt(i));
        }
        return hexed;
    }

    /** Transform string of hex digits to array of decimal equivalent
     * @param hexString contains hex digits between '0' and 'f'
     * @return array of hexString length with corresponding decimal values
     */
    private int[] decimate(String hexString) {
        // create an array to store corresponding values
        int[] key2dec = new int[hexString.length()];

        // map each hex to its decimal value using hash map in Converter
        for (int i=0; i<hexString.length(); i++) {
            key2dec[i] = Mapper.hex2dec(hexString.charAt(i));
        }
        return key2dec;
    }

    /** Transform array of decimal values (that represent hex values) back to ascii string.
     * Every 2 digits makes up a single ascii character (because 2 hex digits = 1 ascii char)
     * 
     * @param decimalArray of values from 0 to 15.
     * @return string of ascii characters corresponding to array
     */
    private String asciify(int[] decimalArray) {

        // start with an empy ascii string
        String hashed = "";

        // transform every 2 elements to a single ascii character
        for (int i=0; i<decimalArray.length; i=i+2) {
            int value = (decimalArray[i]*16 + decimalArray[i+1]);
            // ascii visible characters are between 32 and 126 (94 chars)
            // limit range to 94, then shift to be between 32 and 126
            if (value >126) {
                value = (value % 95) + 32;
            }
            // I don't think this would happen, but just in case
            if (value < 32) {
                value += 32;
            }
            // add the visible ascii character to the output string
            hashed += (char) value;
        }
        return hashed;
    }

    /** Transforms user-entered password to a hashed string
     * @param password user-entered password
     * @param key unique string of ascii characters for hashing password
     * @param salt unique string of ascii characters for creating fixed-length password
     * @return hashed password that can be safely stored in a text file
     */
    public String hash(String password) {

        // convert each ascii character of key to 2 hex digits (into concatenated string)
        String key2hex = hexify(key);
        if (debug) System.out.println(key+" hexed to "+key2hex);

        // convert hex string of key into array of corresponding decimal digits
        int[] key2dec = decimate(key2hex);

        if (debug) printArray(key2dec,"key DECI = ");

        String salted = salt(password);
        if (debug) System.out.println(password+" salted "+salted);

        String hexed = hexify(salted);
        if (debug) System.out.println("hexid "+hexed);

        // convert hexed password (a string of hex values) to array of corresponding decimal digits
        int[] pwd2dec = decimate(hexed);

        if (debug) printArray(pwd2dec,"pwd DECI = ");

        // accumulate across the password
        for (int i=1; i<pwd2dec.length; i++) {
            pwd2dec[i] += pwd2dec[i-1];
        }
        if (debug) printArray(pwd2dec,"key SUMMED = ");
        
        // slide the password across the key, adding together each aligned digit
        // for example, on the first pass the 0th digits align, so 0 to length of password will be added.
        // on the second pass the 0th digit of the password aligns with the 1's place digit of the key.
        // and so on until the first digit of the password aligns with the last digit of the key.

        // outer loop controls the number of times the password is shifted by 1 digit
        for (int i=0; i<(key2dec.length/*-pwd2dec.length*/); i++) {
            // inner loop iterates over each aligned digit and sets pwd value to their sum
            for (int j=0; j<pwd2dec.length; j++) {
                // as long as the current password digit is not aligned past the end of the key
                if ((i+j)<key2dec.length) {
                    // add the 2 digits, keeping it in hex range 0 to 15
                    pwd2dec[j] = key2dec[i+j] + pwd2dec[j];
                }
            }
            if (debug) printArray(pwd2dec,"HASH");
        }
        // mod back into hex range 0 to 15
        for (int i=0; i<pwd2dec.length; i++) {
            pwd2dec[i] = pwd2dec[i] % 16;
        }

        if (debug) printArray(pwd2dec,"MOD ");

        // convert the array of decimals to a corresponding string of ascii's
        String asciid = asciify(pwd2dec);
        
        if (debug) System.out.println("final "+asciid);
        
        return asciid;
    }

    private static void printArray(int[] array, String desc) {
        System.out.print(desc+" ");
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
