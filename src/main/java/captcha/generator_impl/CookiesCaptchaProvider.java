package captcha.generator_impl;


import captcha.Captcha;
import constants.Constants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CookiesCaptchaProvider implements CaptchaProvider {

    private Map<String, Captcha> captchaContainer;

    public CookiesCaptchaProvider() {
        captchaContainer = new HashMap<>();
    }

    @Override
    public Captcha getCaptcha(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Captcha captcha = getCaptchaFromCookies(cookies);
        checkIfInvalidatedCaptchas();
        return captcha;
    }

    @Override
    public void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha) {
        Cookie captcha_id = new Cookie(Constants.CAPTCHA_ID, captcha.getId());
        response.addCookie(captcha_id);
        captchaContainer.put(captcha.getId(), captcha);
    }

    private Captcha getCaptchaFromCookies(Cookie[] cookies) {
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(Constants.CAPTCHA_ID)) {
                    return captchaContainer.get(cookies[i].getValue());
                }
            }
        }
        return null;
    }

    private void checkIfInvalidatedCaptchas() {
        captchaContainer.forEach((key, value) -> {
            if (value.getValue().equals("")) {
                captchaContainer.remove(key);
            }
        });
    }
}
