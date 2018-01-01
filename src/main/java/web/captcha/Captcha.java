package web.captcha;

import java.util.Random;
import java.util.UUID;

public class Captcha {

    private String id;
    private String value;
    private long date;

    /**
     * Generates web.captcha value
     * and web.captcha id
     */
    public Captcha() {
        value = generateCaptchaCode();
        id = generateCaptchaID();
        date = System.currentTimeMillis();
    }

    public long getDate() {
        return date;
    }

    public String getValue() {
        return value;
    }

    public String getId() {
        return id;
    }

    private String generateCaptchaID() {
        return UUID.randomUUID().toString();
    }

    private String generateCaptchaCode() {
        Random random = new Random();
        int result = 1000 + random.nextInt(9000);
        return String.valueOf(result);
    }
}
