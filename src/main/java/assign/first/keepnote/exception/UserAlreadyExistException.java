package assign.first.keepnote.exception;

public class UserAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String message = "user already exists ";

	public UserAlreadyExistException(String message) {

		super(message);
	}
}
