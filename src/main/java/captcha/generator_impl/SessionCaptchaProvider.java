package captcha.generator_impl;

import captcha.Captcha;
import constants.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class SessionCaptchaProvider implements CaptchaProvider {

    private Map<String, Captcha> captchaContainer;

    public SessionCaptchaProvider() {
        captchaContainer = new HashMap<>();
    }

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        String id = (String) request.getSession().getAttribute(Constants.CAPTCHA_ID);
        return captchaContainer.get(id);
    }

    @Override
    public void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha) {
        request.getSession().setAttribute(Constants.CAPTCHA_ID, captcha.getId());
    }
}
