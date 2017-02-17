package common;

/**
 * 
 * This Class generates and logs Custom Exception Messages.
 */
public class UnexpectedException extends Exception {

	private static final long serialVersionUID = 1L;

	private Throwable exceptionType;

	public UnexpectedException() {
		super();
	}

	/**
	 * Parameterized constructor that initializes the exception message string
	 * 
	 * @param exceptionMessage
	 * 
	 */
	public UnexpectedException(String exceptionMessage) {
		super(exceptionMessage);
	}

	/**
	 * Parameterized constructor that initializes the exception message string
	 * and exception type.
	 * 
	 * @param exceptionMessage
	 * @param exceptionType
	 * 
	 */
	public UnexpectedException(String exceptionMessage,
			Throwable exceptionType) {
		super(exceptionMessage);
		this.exceptionType = exceptionType;
	}

	/**
	 * @return exception type.
	 */
	public Throwable getExceptionType() {
		return exceptionType;
	}
}