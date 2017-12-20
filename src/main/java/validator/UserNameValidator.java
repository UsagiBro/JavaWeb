package validator;

import exception.ValidationException;

import java.util.regex.Pattern;

public class UserNameValidator implements Validator<String> {

    private static final String REGEX_FOR_NAME = "([a-zA-Zа-яА-Яё]){2,64}";
    private static final Pattern PATTERN_FOR_NAME = Pattern.compile(REGEX_FOR_NAME);

    @Override
    public void validate(String name) throws ValidationException {
        if (name == null || !ValidatorUtil.matchPattern(PATTERN_FOR_NAME, name)) {
            throw new ValidationException("Name can contain only letters and be longer than 1 symbol");
        }
    }
}
