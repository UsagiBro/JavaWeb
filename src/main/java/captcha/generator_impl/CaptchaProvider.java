package captcha.generator_impl;

import captcha.Captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CaptchaProvider {

    Captcha getCaptcha(HttpServletRequest request);

    void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha);
}
