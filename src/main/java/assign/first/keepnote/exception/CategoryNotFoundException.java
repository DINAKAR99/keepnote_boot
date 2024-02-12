package assign.first.keepnote.exception;

public class CategoryNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String message = "category not found ";

	public CategoryNotFoundException(String message) {
		super(message);
	}

	public CategoryNotFoundException() {
		// TODO Auto-generated constructor stub
	}
}
