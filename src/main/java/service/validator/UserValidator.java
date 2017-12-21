package service.validator;

import storage.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static service.validator.ValidationConstants.REGEX_FOR_EMAIL;
import static service.validator.ValidationConstants.REGEX_FOR_NAME;
import static service.validator.ValidationConstants.REGEX_FOR_PASSWORD;

public class UserValidator {

    private Map<String, String> errors;
    private static final Pattern PATTERN_FOR_EMAIL = Pattern.compile(REGEX_FOR_EMAIL);
    private static final Pattern PATTERN_FOR_NAME = Pattern.compile(REGEX_FOR_NAME);
    private static final Pattern PATTERN_FOR_PASSWORD = Pattern.compile(REGEX_FOR_PASSWORD);

    public UserValidator(Map<String, String> errors) {
        this.errors = errors;
    }

    public void validate(User user) {
        if (user.getEmail() == null || !ValidatorUtil.matchPattern(PATTERN_FOR_EMAIL, user.getEmail())) {
            errors.put(ValidationConstants.EMAIL, ValidationConstants.EMAIL_VALIDATION_EXCEPTION);
        }
        if (user.getName() == null || user.getSurname() == null ||
                !ValidatorUtil.matchPattern(PATTERN_FOR_NAME, user.getName()) ||
                !ValidatorUtil.matchPattern(PATTERN_FOR_NAME, user.getSurname())) {
            errors.put(ValidationConstants.NAME, ValidationConstants.NAME_VALIDATION_EXCEPTION);
        }
        if (user.getPassword() == null || !ValidatorUtil.matchPattern(PATTERN_FOR_PASSWORD, user.getPassword())) {
            errors.put(ValidationConstants.PASSWORD, ValidationConstants.PASSWORD_VALIDATION_EXCEPTION);
        }

    }
}
