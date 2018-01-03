package captcha.generator_impl;


import captcha.Captcha;
import constants.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class HiddenFieldCaptchaProvider implements CaptchaProvider {

    private Map<String, Captcha> captchas;

    public HiddenFieldCaptchaProvider() {
        captchas = new HashMap<>();
    }

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        String captchaId = (String) request.getSession().getAttribute(Constants.CAPTCHA_ID);
        Captcha captcha = captchas.get(captchaId);
        checkIfInvalidatedCaptchas(captchas);
        return captcha;
    }

    @Override
    public void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha) {
        captchas.put(captcha.getId(), captcha);
        request.getSession().setAttribute(Constants.CAPTCHA_ID, captcha.getId());
    }

    private void checkIfInvalidatedCaptchas(Map<String, Captcha> captchaContainer) {
        captchaContainer.forEach((key, value) -> {
            if (value.equals("")) {
                captchaContainer.remove(key);
            }
        });
    }
}
