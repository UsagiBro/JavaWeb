package captcha;

import captcha.generator_impl.CaptchaProvider;
import captcha.generator_impl.CookiesCaptchaProvider;
import captcha.generator_impl.HiddenFieldCaptchaProvider;
import captcha.generator_impl.SessionCaptchaProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CaptchaStrategyGenerator {

    private Map<String, Supplier<CaptchaProvider>> captchaStrategies;

    public CaptchaStrategyGenerator() {
        captchaStrategies = new HashMap<>();
        captchaStrategies.put("hidden", this::generateHiddenFieldCaptchaGenerator);
        captchaStrategies.put("session", this::generateSessionCaptchaGenerator);
        captchaStrategies.put("cookies", this::generateCookiesCaptchaGenerator);
    }

    public CaptchaProvider getGeneratorFromStrategy(String strategy) {
        return captchaStrategies.get(strategy).get();
    }

    private CaptchaProvider generateHiddenFieldCaptchaGenerator() {
        return new HiddenFieldCaptchaProvider();
    }

    private CaptchaProvider generateSessionCaptchaGenerator() {
        return new SessionCaptchaProvider();
    }

    private CaptchaProvider generateCookiesCaptchaGenerator() {
        return new CookiesCaptchaProvider();
    }
}
