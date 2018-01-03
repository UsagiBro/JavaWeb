package service.validator;

import captcha.Captcha;
import constants.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CaptchaValidator {

    /**
     * Check if entered captcha value is valid
     * @param captcha true captcha that was set when captcha created
     * @param enteredValue entered captcha value
     * @return map of errors (empty if errors don't exist)
     */
    public Map<String, String> validate(Captcha captcha, String enteredValue, long captchaTimeOut) {
        Map<String, String> resultMap = new HashMap<>();
        if (!Objects.equals(captcha.getValue(), enteredValue)) {
            resultMap.put(Constants.CAPTCHA, Constants.INVALID_CAPTCHA_EXCEPTION);
        }
        long current = System.currentTimeMillis();
        if (current - captcha.getDate() > captchaTimeOut) {
            resultMap.put(Constants.CAPTCHA, Constants.CAPTCHA_TIME_OUT_EXCEPTION);
        }
        return resultMap;
    }
}
