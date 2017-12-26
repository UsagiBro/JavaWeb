package constants;

public final class Constants {

    private Constants() {
        throw new IllegalStateException("Can't create an instance");
    }

    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String PASSWORD = "password";
    public static final String ERRORS = "errors";
    public static final String USER_EXISTS_KEY = "user_exists";
    public static final String CAPTCHA_PROVIDER = "captchaProvider";
    public static final String USER_SERVICE = "userService";
    public static final String CAPTCHA_ID = "captchaId";
    public static final String CAPTCHA_VALUE = "captchaVal";
    public static final String CAPTCHA = "captcha";

    public static final String REGEX_FOR_NAME = "([a-zA-Zа-яА-Яё]){2,64}";
    public static final String REGEX_FOR_EMAIL = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    public static final String REGEX_FOR_PASSWORD = "(\\w|\\d){5,16}";

    public static final String NAME_VALIDATION_EXCEPTION = "Name can contain only letters and be longer than 1 symbol";
    public static final String PASSWORD_VALIDATION_EXCEPTION =
            "Password can consist of letters and numbers and must be longer than 4 symbols";
    public static final String EMAIL_VALIDATION_EXCEPTION = "Type valid email";
    public static final String USER_EXISTS = "Such user email already exists!";
    public static final String INVALID_CAPTCHA_EXCEPTION = "Invalid captcha, please try again!";
}
