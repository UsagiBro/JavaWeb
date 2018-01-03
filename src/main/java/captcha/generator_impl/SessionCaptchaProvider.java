package captcha.generator_impl;

import captcha.Captcha;
import constants.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionCaptchaProvider implements CaptchaProvider {

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        Captcha captcha = (Captcha) request.getSession().getAttribute(Constants.CAPTCHA);
        return captcha;
    }

    @Override
    public void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha) {
        request.getSession().setAttribute(Constants.CAPTCHA, captcha);
    }
}
