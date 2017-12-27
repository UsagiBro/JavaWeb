package captcha.generator_impl;

import captcha.Captcha;
import constants.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class SessionCaptchaProvider implements CaptchaProvider {

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        return (Captcha) request.getSession().getAttribute(Constants.CAPTCHA);
    }

    @Override
    public void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha) {
        request.getSession().setAttribute(Constants.CAPTCHA, captcha);
    }
}
