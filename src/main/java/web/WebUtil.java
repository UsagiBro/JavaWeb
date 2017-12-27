package web;

import constants.Constants;
import storage.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class WebUtil {

    private WebUtil() {
        throw new IllegalStateException("Can't create an instance of this class");
    }

    public static User getUserParameters(HttpServletRequest req) {
        String name = req.getParameter(Constants.NAME);
        String surname = req.getParameter(Constants.SURNAME);
        String password = req.getParameter(Constants.PASSWORD);
        String email = req.getParameter(Constants.EMAIL);

        return new User(name, surname, password, email);
    }

    public static void setEnteredValuesToSession(User user, HttpSession session) {
        session.setAttribute(Constants.NAME, user.getName());
        session.setAttribute(Constants.SURNAME, user.getSurname());
        session.setAttribute(Constants.EMAIL, user.getEmail());
    }

    public static void removeEnteredValuesFromSession(HttpSession session) {
        session.removeAttribute(Constants.NAME);
        session.removeAttribute(Constants.SURNAME);
        session.removeAttribute(Constants.EMAIL);
        session.removeAttribute(Constants.ERRORS);
    }
}
