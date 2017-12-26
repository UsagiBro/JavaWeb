package service.captcha;

import captcha.Captcha;

import java.util.Map;

public interface CaptchaService {

    boolean checkCaptcha(Captcha captcha, String captchaValue);

    Map<String, String> getErrors();
}
