package service.validator;

import constants.WebConstants;
import entity.UserBean;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static constants.WebConstants.REGEX_FOR_EMAIL;
import static constants.WebConstants.REGEX_FOR_NAME;
import static constants.WebConstants.REGEX_FOR_PASSWORD;

public class UserValidator implements Validator<UserBean> {


    private static final Pattern PATTERN_FOR_EMAIL = Pattern.compile(REGEX_FOR_EMAIL);
    private static final Pattern PATTERN_FOR_NAME = Pattern.compile(REGEX_FOR_NAME);
    private static final Pattern PATTERN_FOR_PASSWORD = Pattern.compile(REGEX_FOR_PASSWORD);

    public Map<String, String> validate(UserBean userBean) {
        Map<String, String> errors = new HashMap<>();
        if (userBean.getEmail() == null || !ValidatorUtil.matchPattern(PATTERN_FOR_EMAIL, userBean.getEmail())) {
            errors.put(WebConstants.EMAIL, WebConstants.EMAIL_VALIDATION_EXCEPTION);
        }
        if (userBean.getName() == null || userBean.getSurname() == null ||
                !ValidatorUtil.matchPattern(PATTERN_FOR_NAME, userBean.getName()) ||
                !ValidatorUtil.matchPattern(PATTERN_FOR_NAME, userBean.getSurname())) {
            errors.put(WebConstants.NAME, WebConstants.NAME_VALIDATION_EXCEPTION);
        }
        if (userBean.getPassword() == null || !ValidatorUtil.matchPattern(PATTERN_FOR_PASSWORD, userBean.getPassword())) {
            errors.put(WebConstants.PASSWORD, WebConstants.PASSWORD_VALIDATION_EXCEPTION);
        }
        if (!userBean.getPassword().equals(userBean.getPasswordRepeat())) {
            errors.put(WebConstants.PASSWORD_REPEAT, WebConstants.PASSWORD_REPEAT_EXCEPTION);
        }
        return errors;
    }
}
