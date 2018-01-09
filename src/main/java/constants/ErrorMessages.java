package constants;

public final class ErrorMessages {
    private ErrorMessages() {
        throw new IllegalStateException("Can't create instance of a class!");
    }

    public static final String USER_EXISTS_KEY = "user_exists";
    public static final String WRONG_AUTHORIZATION = "wrong_authorization";
    public static final String AUTHORIZATION_ERROR = "Wrong email or password!";
    public static final String NAME_VALIDATION_EXCEPTION = "Name can contain only letters and be longer than 1 symbol";
    public static final String PASSWORD_VALIDATION_EXCEPTION =
            "Password can consist of letters and numbers and must be longer than 4 symbols";
    public static final String EMAIL_VALIDATION_EXCEPTION = "Type valid email";
    public static final String PASSWORD_REPEAT_EXCEPTION = "Passwords don't match";
    public static final String USER_EXISTS = "User with such email already exists!";
    public static final String INVALID_CAPTCHA_EXCEPTION = "Invalid web.captcha, please try again!";
    public static final String CAPTCHA_TIME_OUT_EXCEPTION = "Captcha has timed out!";
    public static final String FILE_IS_INVALID = "File isn't valid!";
    public static final String AVATAR_OVERLOAD = "Too big picture for avatar!";
    public static final String WRONG_AVATAR_FORMAT = "Attached file must be jpeg or png";

}
