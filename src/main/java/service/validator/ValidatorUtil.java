package service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidatorUtil {

    private ValidatorUtil() {
        throw new IllegalStateException("Can't create an instance");
    }

    /**
     * Returns true when string matches pattern or false if not.
     * @param pattern pattern for check
     * @param checkString string to be checked
     * @return true when string matches pattern or false if not
     */
    public static boolean matchPattern(Pattern pattern, String checkString) {
        Matcher matcher = pattern.matcher(checkString);
        return matcher.matches();
    }
}
