package assign.first.keepnote.exception;

public class ReminderNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String message = "reminder not found ";

	public ReminderNotFoundException(String message) {

		super(message);
	}

	public ReminderNotFoundException() {
		// TODO Auto-generated constructor stub
	}
}
