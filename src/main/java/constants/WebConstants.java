package constants;

public final class WebConstants {


    private WebConstants() {
        throw new IllegalStateException("Can't create an instance");
    }



    public static final String USER = "user";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String PASSWORD_REPEAT = "passwordRepeat";
    public static final String NEWS = "news";
    public static final String AVATAR = "avatar";
    public static final String NEW_PRODUCTS = "newProducts";
    public static final String USER_EXISTS_KEY = "user_exists";
    public static final String CAPTCHA_ID = "captchaId";
    public static final String CAPTCHA_VALUE = "captchaVal";
    public static final String CAPTCHA = "captcha";
    public static final String ERRORS = "errors";
    public static final String CAPTCHA_TIME = "captcha-time";

    public static final String CAPTCHA_PROVIDER = "captchaProvider";
    public static final String USER_SERVICE = "userService";

    public static final String REGEX_FOR_NAME = "([a-zA-Zа-яА-Яё]){2,64}";
    public static final String REGEX_FOR_EMAIL = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    public static final String REGEX_FOR_PASSWORD = "(\\w|\\d){5,16}";

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
    public static final String FILE_IS_NOT_UPLOADED = "File isn't uploaded";

}
