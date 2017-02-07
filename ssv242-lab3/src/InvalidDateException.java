@SuppressWarnings("serial")
/**
 * This exception should be thrown when a Date object
 * contains incorrect information or is not valid.
 * 
 * @author Alan Wernick
 */
public class InvalidDateException extends Exception {
	public InvalidDateException(String message) {
		super(message);
	}
}