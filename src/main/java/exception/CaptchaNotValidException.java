package exception;

public class CaptchaNotValidException extends Exception {
    public CaptchaNotValidException(String message) {
        super(message);
    }
}
