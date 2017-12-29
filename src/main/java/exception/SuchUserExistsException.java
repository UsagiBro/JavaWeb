package exception;

public class SuchUserExistsException extends Exception {

    public SuchUserExistsException(String message) {
        super(message);
    }
}
