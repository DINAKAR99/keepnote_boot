package assign.first.keepnote.exception;

public class NoteNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String message = "note not found ";

	public NoteNotFoundException(String message) {
		super(message);

	}

	public NoteNotFoundException() {
		// TODO Auto-generated constructor stub
	}

}
