package exception;

public class IncorrectIdException extends Exception {

    public IncorrectIdException() {
        super();
    }

    public IncorrectIdException(String message) {
        super(message);
    }

    public IncorrectIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
