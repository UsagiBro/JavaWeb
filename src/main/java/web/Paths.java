package web;

public final class Paths {
    private Paths() {
        throw new IllegalStateException("Can't create an instance of this class");
    }

    public static final String REGISTRATION_JSP =  "/WEB-INF/jsp/registration.jsp";
    public static final String AUTHORIZATION_HTML = "authorization.html";
    public static final String REGISTRATION_SERVLET ="registration";
}
