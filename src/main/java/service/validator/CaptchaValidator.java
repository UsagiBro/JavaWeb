package service.validator;

import constants.WebConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CaptchaValidator {

    public Map<String, String> validate(String captchaValue, String enteredValue) {
        Map<String, String> resultMap = new HashMap<>();
        if (!Objects.equals(captchaValue, enteredValue)) {
            resultMap.put(WebConstants.CAPTCHA, WebConstants.INVALID_CAPTCHA_EXCEPTION);
        }
        return resultMap;
    }
}
