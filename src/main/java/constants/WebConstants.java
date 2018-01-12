package constants;

public final class WebConstants {

    private WebConstants() {
        throw new IllegalStateException("Can't create an instance");
    }



    public static final Integer START_PAGE = 1;
    public static final Integer DEFAULT_COUNT_OF_INSTRUMENTS_ON_PAGE = 18;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String REGEX_FOR_DIGIT = "\\d+";
    public static final String REGEX_FOR_NAME = "([a-zA-Zа-яА-Яё]){2,64}";
    public static final String REGEX_FOR_EMAIL = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    public static final String REGEX_FOR_PASSWORD = "(\\w|\\d){5,16}";

    public static final String CAPTCHA_ID = "captchaId";
    public static final String CAPTCHA_VALUE = "captchaVal";
    public static final String CAPTCHA = "captcha";
    public static final String ERRORS = "errors";
    public static final String USER = "user";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String PASSWORD_REPEAT = "passwordRepeat";
    public static final String NEWS = "news";
    public static final String AVATAR = "avatar";
    public static final String NEW_PRODUCTS = "newProducts";


    public static final String INSTRUMENTS_COUNT = "instrumentCount";
    public static final String FILTER_CATEGORY = "filterCategory";
    public static final String FILTER_MANUFACTURER = "filterManufacturer";
    public static final String SORT_VALUE = "sortValue";
    public static final String SORT_DIRECTION = "sortDirection";
    public static final String SORT_BACKWARD = "sortBackward";
    public static final String MANUFACTURER_LIST = "manufacturerList";
    public static final String CATEGORIES_LIST = "categoriesList";
    public static final String CATEGORY_SERVICE = "categoryService";
    public static final String FILTER_BEAN = "filterBean";
    public static final String LIST_OFFSET = "offset";
    public static final String CURRENT_PAGE = "currentPage";
    public static final String PAGE = "page";
    public static final String PAGE_COUNT = "pagesCount";


    public static final String MANUFACTURER_SERVICE = "manufacturerService";
    public static final String CAPTCHA_TIME = "captcha-time";
    public static final String AVATAR_SIZE = "avatar_size";
    public static final String CAPTCHA_PROVIDER = "captchaProvider";
    public static final String USER_SERVICE = "userService";
    public static final String INSTRUMENT_SERVICE = "instrumentService";
    public static final String INSTRUMENT_BEAN = "instrumentBean";

}
