package service.validator;

public final class ValidationConstants {

    private ValidationConstants() {
        throw new IllegalStateException("Can't create an instance");
    }

    public static final String REGEX_FOR_NAME = "([a-zA-Zа-яА-Яё]){2,64}";
    public static final String REGEX_FOR_EMAIL = "(\\w|\\d){5,16}";
    public static final String REGEX_FOR_PASSWORD = "(\\w|\\d){5,16}";
    public static final String NAME_VALIDATION_EXCEPTION = "Name can contain only letters and be longer than 1 symbol";
    public static final String PASSWORD_VALIDATION_EXCEPTION =
            "Password can consist of letters and numbers and must be longer than 4 symbols";
    public static final String EMAIL_VALIDATION_EXCEPTION = "Type valid email";
}
