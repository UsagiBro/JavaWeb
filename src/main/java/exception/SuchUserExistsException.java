package exception;

/**
 * Thrown if user with inputted parameters already exists in database and can't be created
 */
public class SuchUserExistsException extends Exception {

    public SuchUserExistsException(String message) {
        super(message);
    }
}
