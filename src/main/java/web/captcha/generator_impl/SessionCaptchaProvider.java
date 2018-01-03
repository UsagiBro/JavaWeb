package web.captcha.generator_impl;

import web.captcha.Captcha;
import constants.WebConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionCaptchaProvider implements CaptchaProvider {

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        Captcha captcha = (Captcha) request.getSession().getAttribute(WebConstants.CAPTCHA);
        return captcha;
    }

    @Override
    public void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha) {
        request.getSession().setAttribute(WebConstants.CAPTCHA, captcha);
    }
}
