/** Stores a pair of Strings. 
* This is a homegrown version of the Java Pair with generic type. 
*/
public class Pair {
	/** The first value of the pair */
	String value1;
	/** The second value of the pair */
	String value2;

	/** Constructor with values to add.
	 * 
	 * @param v1 value stored as the first in the pair
	 * @param v2 value stored as the second in the pair
	 */
	public Pair(String v1, String v2) {
		value1 = v1;
		value2 = v2;
	}
	
	@Override
	public String toString() {
		return value1+", "+value2;
	}
	
	/** Getter for either the first or second element. */
	String get(int n) {
		// only 1 and 2 are valid. Ignore anything else.
		if (n!=1 && n!=2) { return null; }

		// return the requested value
		return (n==1)?value1:value2;
	}
}

