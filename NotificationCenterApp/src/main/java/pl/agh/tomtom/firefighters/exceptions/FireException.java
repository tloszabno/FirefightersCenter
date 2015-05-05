package pl.agh.tomtom.firefighters.exceptions;

public class FireException extends Exception {

	public FireException() {
	}

	public FireException(String message) {
		super(message);
	}

	public FireException(Throwable cause) {
		super(cause);
	}

	public FireException(String message, Throwable cause) {
		super(message, cause);
	}

	public FireException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
