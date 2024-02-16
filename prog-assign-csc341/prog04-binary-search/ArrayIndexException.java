import java.lang.Exception;

/**
* Exception for handling invalid indices in the array for List.
*/
public class ArrayIndexException extends Exception {

	/**
	* Constructor
	* @param msg Information related to the thrown exception.
	*/
	public ArrayIndexException(String msg) {
		// call the Exception constructor
		super("ArrayIndexException: "+msg);
	}
}