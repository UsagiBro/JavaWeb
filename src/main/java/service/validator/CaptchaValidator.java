package service.validator;

import captcha.Captcha;

import java.util.Objects;

public class CaptchaValidator {

    public boolean validate(Captcha captcha, String captchaValue) {
        if (Objects.equals(captcha.getValue(), captchaValue)) {
            return true;
        }
        return false;
    }
}
