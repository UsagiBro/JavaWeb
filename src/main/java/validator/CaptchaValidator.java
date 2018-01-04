package validator;

import constants.WebConstants;
import web.captcha.Captcha;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CaptchaValidator {

    public Map<String, String> validate(Captcha captcha, String enteredValue, long captchaTimeOut) {
        Map<String, String> resultMap = new HashMap<>();
        if (!Objects.equals(captcha.getValue(), enteredValue)) {
            resultMap.put(WebConstants.CAPTCHA, WebConstants.INVALID_CAPTCHA_EXCEPTION);
        }
        long current = System.currentTimeMillis();
        if (current - captcha.getDate() > captchaTimeOut) {
            resultMap.put(WebConstants.CAPTCHA, WebConstants.CAPTCHA_TIME_OUT_EXCEPTION);
        }
        return resultMap;
    }

}
