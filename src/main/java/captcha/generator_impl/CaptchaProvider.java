package captcha.generator_impl;

import captcha.Captcha;
import exception.CaptchaNotValidException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

public interface CaptchaProvider {

    String getCaptcha(HttpServletRequest request) throws CaptchaNotValidException;

    void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha);

    default void checkCaptchaValidity(Captcha captcha) throws CaptchaNotValidException {
        long current = System.currentTimeMillis();
        if (current - captcha.getDate() > 1200000) {
            throw new CaptchaNotValidException("Capcha has timed out!");
        }
    }
}
