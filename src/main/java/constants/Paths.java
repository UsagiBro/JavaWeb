package constants;

public final class Paths {

    private Paths() {
        throw new IllegalStateException("Can't create an instance of this class");
    }

    public static final String REGISTRATION_JSP =  "/WEB-INF/jsp/registration.jsp";
    public static final String AUTHORIZATION_JSP = "/WEB-INF/jsp/authorization.jsp";
    public static final String USER_CABINET_JSP = "/WEB-INF/jsp/userCabinet.jsp";
    public static final String IMAGES_PATH =  "src/main/webapp/src";
    public static final String DEFAULT_IMAGE_PATH = "src/main/webapp/assets/images/default-avatar.png";

    public static final String REGISTRATION_SERVLET ="registration";
    public static final String AUTHORIZATION_SERVLET ="authorization";
    public static final String CABINET_SERVLET ="cabinet";

}
