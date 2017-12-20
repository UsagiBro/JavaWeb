package service.validator.user_validator;

import exception.ValidationException;
import service.validator.ValidationConstants;
import service.validator.Validator;
import service.validator.ValidatorUtil;

import java.util.regex.Pattern;

import static service.validator.ValidationConstants.REGEX_FOR_EMAIL;

public class UserEmailValidator implements Validator<String> {


    private static final Pattern PATTERN_FOR_EMAIL = Pattern.compile(REGEX_FOR_EMAIL);

    @Override
    public void validate(String email) throws ValidationException {
        if (email == null || !ValidatorUtil.matchPattern(PATTERN_FOR_EMAIL, email)) {
            throw new ValidationException(ValidationConstants.EMAIL_VALIDATION_EXCEPTION);
        }
    }
}
