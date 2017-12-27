package web;

import constants.Constants;
import entity.User;
import entity.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class WebUtil {

    private WebUtil() {
        throw new IllegalStateException("Can't create an instance of this class");
    }

    public static User getUserFromUserBeanParameters(UserBean userBean) {
        String name = userBean.getName();
        String surname = userBean.getSurname();
        String password = userBean.getPassword();
        String email = userBean.getEmail();
        boolean news = userBean.getNews();
        boolean newProducts = userBean.getNewProducts();


        return new User(name, surname, password, email, news, newProducts);
    }

    public static UserBean getUserBeanFromRequest(HttpServletRequest req) {
        String name = req.getParameter(Constants.NAME);
        String surname = req.getParameter(Constants.SURNAME);
        String password = req.getParameter(Constants.PASSWORD);
        String email = req.getParameter(Constants.EMAIL);
        String passwordRepeat = req.getParameter(Constants.PASSWORD_REPEAT);
        boolean news = req.getParameter(Constants.NEWS) != null;
        boolean newProducts = req.getParameter(Constants.NEW_PRODUCTS) != null;

        return new UserBean(name, surname, password, email, passwordRepeat, news, newProducts);
    }

//    public static void setEnteredValuesToSession(User user, HttpSession session) {
//        session.setAttribute(Constants.NAME, user.getName());
//        session.setAttribute(Constants.SURNAME, user.getSurname());
//        session.setAttribute(Constants.EMAIL, user.getEmail());
//    }

    public static void setEnteredValuesToSession(UserBean userBean, HttpSession session) {
        session.setAttribute(Constants.NAME, userBean.getName());
        session.setAttribute(Constants.SURNAME, userBean.getSurname());
        session.setAttribute(Constants.EMAIL, userBean.getEmail());
        session.setAttribute(Constants.NEWS, userBean.getNews());
        session.setAttribute(Constants.NEW_PRODUCTS, userBean.getNewProducts());
    }

    public static void removeEnteredValuesFromSession(HttpSession session) {
        session.removeAttribute(Constants.NAME);
        session.removeAttribute(Constants.SURNAME);
        session.removeAttribute(Constants.EMAIL);
        session.removeAttribute(Constants.NEWS);
        session.removeAttribute(Constants.NEW_PRODUCTS);
        session.removeAttribute(Constants.ERRORS);
        session.removeAttribute(Constants.CAPTCHA_VALUE);
    }
}
