package service.validator.user_validator;

import exception.ValidationException;
import service.validator.ValidationConstants;
import service.validator.Validator;
import service.validator.ValidatorUtil;

import java.util.regex.Pattern;

import static service.validator.ValidationConstants.REGEX_FOR_PASSWORD;

public class UserPasswordValidator implements Validator<String> {

    private static final Pattern PATTERN_FOR_PASSWORD = Pattern.compile(REGEX_FOR_PASSWORD);

    @Override
    public void validate(String password) throws ValidationException {
        if (password == null || !ValidatorUtil.matchPattern(PATTERN_FOR_PASSWORD, password)) {
            throw new ValidationException(ValidationConstants.PASSWORD_VALIDATION_EXCEPTION);
        }
    }
}
