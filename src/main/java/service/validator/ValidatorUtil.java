package service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidatorUtil {

    private ValidatorUtil() {
        throw new IllegalStateException("Can't create an instance");
    }

    public static boolean matchPattern(Pattern pattern, String checkString) {
        Matcher matcher = pattern.matcher(checkString);
        return matcher.matches();
    }
}
