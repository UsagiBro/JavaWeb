package constants;

public final class Paths {

    private Paths() {
        throw new IllegalStateException("Can't create an instance of this class");
    }

    public static final String INDEX_HTML = "index.html";
    public static final String REGISTRATION_JSP =  "/WEB-INF/jsp/registration.jsp";
    public static final String AUTHORIZATION_JSP = "/WEB-INF/jsp/authorization.jsp";

    public static final String REGISTRATION_SERVLET ="registration";
    public static final String AUTHORIZATION_SERVLET ="authorization";

}
