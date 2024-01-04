import java.util.Random;
import java.util.ArrayList;
import java.io.*;

/* Manages a login window for students.
 * The hasher transforms a password that the user entered to a hashed (encrypted) form.
 * The hashed password can be compared against the stored hashed password to verify the user.
 * 
 * Usernames and hashed passwords are stored in the file users.txt.
 * 
 * Usernames and "clear text" passwords are stored in the file users-cleartext-BAD.txt, 
 * because you would NEVER store them this way. But this provides some test cases for you.
 * 
 * Finally, a student "database" has been provided so that students can access their data
 * once their login credentials have been verified.
 * 
 */
public class Main {

    // Hash key and salt string used to transform the user-entered password.
    static String salt = "+_)(*&^%$#@!";
    static String key = "E827g4D;C^#4,nZ$m7]kq-s0Wj3R=CrX";

    static Hasher hasher = new Hasher(salt,key);    
    
    public static void main(String[] args) {
    
		Database db = new Database(hasher);
  
		// Start the popup login window and wait for user to enter credentials.
		LoginWindow window = new LoginWindow(db);
		window.setVisible(true);
		
		// To stop the program, close the popup window

    }
}
