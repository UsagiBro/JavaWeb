package service.validator.user_validator;

import exception.ValidationException;
import service.validator.ValidationConstants;
import service.validator.Validator;
import service.validator.ValidatorUtil;

import java.util.regex.Pattern;

import static service.validator.ValidationConstants.REGEX_FOR_NAME;

public class UserNameValidator implements Validator<String> {

    private static final Pattern PATTERN_FOR_NAME = Pattern.compile(REGEX_FOR_NAME);

    @Override
    public void validate(String name) throws ValidationException {
        if (name == null || !ValidatorUtil.matchPattern(PATTERN_FOR_NAME, name)) {
            throw new ValidationException(ValidationConstants.NAME_VALIDATION_EXCEPTION);
        }
    }
}
