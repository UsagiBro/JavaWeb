package exception;

/**
 * Throws if captcha isn't valid
 */
public class CaptchaNotValidException extends Exception {

    public CaptchaNotValidException(String message) {
        super(message);
    }
}
