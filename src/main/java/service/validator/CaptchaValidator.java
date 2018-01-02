package service.validator;

import constants.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CaptchaValidator {

    /**
     * Check if entered captcha value is valid
     * @param captchaValue true captcha value that was set when captcha created
     * @param enteredValue entered captcha value
     * @return map of errors (empty if errors don't exist)
     */
    public Map<String, String> validate(String captchaValue, String enteredValue) {
        Map<String, String> resultMap = new HashMap<>();
        if (!Objects.equals(captchaValue, enteredValue)) {
            resultMap.put(Constants.CAPTCHA, Constants.INVALID_CAPTCHA_EXCEPTION);
        }
        return resultMap;
    }
}
