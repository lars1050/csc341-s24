import java.lang.Exception;

/**
* Exception for handling operations on the List that cannot be executed.
*/
public class IllegalOperationException extends Exception {

	/**
	* Constructor
	* @param msg Information related to the thrown exception.
	*/
	public IllegalOperationException(String msg) {
		// call the Exception constructor
		super("IllegalOperationException: "+msg);
	}
}