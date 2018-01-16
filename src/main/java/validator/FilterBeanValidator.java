package validator;

import constants.WebConstants;
import entity.dto.FilterBean;
import exception.FilterValidationException;
import util.ValidatorUtil;

import java.util.Objects;
import java.util.regex.Pattern;

public class FilterBeanValidator {

    private static final Pattern PATTERN_FOR_DIGIT = Pattern.compile(WebConstants.REGEX_FOR_DIGIT);

    public void validateParameterForFilterBean(String parameter) {
        if (!ValidatorUtil.matchPattern(PATTERN_FOR_DIGIT, String.valueOf(parameter))) {
            throw new FilterValidationException();
        }
    }
}
