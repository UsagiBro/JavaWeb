package captcha.generator_impl;

import captcha.Captcha;
import constants.WebConstants;
import exception.CaptchaNotValidException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionCaptchaProvider implements CaptchaProvider {

    @Override
    public String getCaptcha(HttpServletRequest request) throws CaptchaNotValidException {
        Captcha captcha = (Captcha) request.getSession().getAttribute(WebConstants.CAPTCHA);
        checkCaptchaValidity(captcha);
        return captcha.getValue();
    }

    @Override
    public void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha) {
        request.getSession().setAttribute(WebConstants.CAPTCHA, captcha);
    }
}
