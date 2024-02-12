package assign.first.keepnote.exception;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	static final String message = "user not found ";

	public UserNotFoundException(String message) {
		super(message);
	}
}
