package captcha;

import java.util.Random;
import java.util.UUID;

public class Captcha {

    private String id;
    private String code;

    /**
     * Generates captcha code
     * and captcha id
     */
    public Captcha() {
        code = generateCaptchaCode();
        id = generateCaptchaID();
    }

    public String getValue() {
        return code;
    }

    public void setValue(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String generateCaptchaID() {
        return UUID.randomUUID().toString();
    }

    private String generateCaptchaCode() {
        Random random = new Random();
        int result = 100000 + random.nextInt(900000);
        return String.valueOf(result);
    }
}
