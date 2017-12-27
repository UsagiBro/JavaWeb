package captcha.generator_impl;


import captcha.Captcha;
import constants.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class HiddenFieldCaptchaProvider implements CaptchaProvider {

    private Map<String, String> captchas;

    public HiddenFieldCaptchaProvider() {
        captchas = new HashMap<>();
    }

    @Override
    public String getCaptcha(HttpServletRequest request) {
        String captchaId = request.getParameter(Constants.CAPTCHA_ID);
        String captchaValue = captchas.get(captchaId);
        checkIfInvalidatedCaptchas(captchas);
        return captchaValue;
    }

    @Override
    public void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha) {
        captchas.put(captcha.getId(), captcha.getValue());
        request.setAttribute(Constants.CAPTCHA_ID, captcha.getId());
    }

    private void checkIfInvalidatedCaptchas(Map<String, String> captchaContainer) {
        captchaContainer.forEach((key, value) -> {
            if (value.equals("")) {
                captchaContainer.remove(key);
            }
        });
    }
}
