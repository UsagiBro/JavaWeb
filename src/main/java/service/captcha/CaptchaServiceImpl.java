package service.captcha;

import captcha.Captcha;
import constants.Constants;
import service.validator.CaptchaValidator;

import java.util.HashMap;
import java.util.Map;

public class CaptchaServiceImpl implements CaptchaService {

    private Map<String, String> errors;
    private CaptchaValidator captchaValidator;

    public CaptchaServiceImpl() {
        errors = new HashMap<>();
        captchaValidator = new CaptchaValidator();
    }

    @Override
    public boolean checkCaptcha(Captcha captcha, String captchaValue) {
        if (captchaValidator.validate(captcha, captchaValue)) {
            return true;
        }
        errors.put(Constants.CAPTCHA, Constants.INVALID_CAPTCHA_EXCEPTION);
        return false;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
