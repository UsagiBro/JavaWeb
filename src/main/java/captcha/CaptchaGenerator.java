package captcha;

import java.util.Random;

public interface CaptchaGenerator {

    void generateCaptcha();

    default int createCaptchaValue() {
        Random random = new Random();
        return random.nextInt();
    }
}
