package captcha;

import captcha.generator_impl.CookiesCaptchaGenerator;
import captcha.generator_impl.HiddenFieldCaptchaGenerator;
import captcha.generator_impl.SessionCaptchaGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CaptchaStrategyGenerator {

    private Map<String, Supplier<CaptchaGenerator>> captchaStrategies;

    public CaptchaStrategyGenerator() {
        captchaStrategies = new HashMap<>();
        captchaStrategies.put("hidden", this::generateHiddenFieldCaptchaGenerator);
        captchaStrategies.put("session", this::generateSessionCaptchaGenerator);
        captchaStrategies.put("cookies", this::generateCookiesCaptchaGenerator);
    }

    public CaptchaGenerator getGeneratorFromStrategy(String strategy) {
        return captchaStrategies.get(strategy).get();
    }

    private CaptchaGenerator generateHiddenFieldCaptchaGenerator() {
        return new HiddenFieldCaptchaGenerator();
    }

    private CaptchaGenerator generateSessionCaptchaGenerator() {
        return new SessionCaptchaGenerator();
    }

    private CaptchaGenerator generateCookiesCaptchaGenerator() {
        return new CookiesCaptchaGenerator();
    }
}
