package util;

import constants.WebConstants;
import entity.User;
import entity.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

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
        String name = req.getParameter(WebConstants.NAME);
        String surname = req.getParameter(WebConstants.SURNAME);
        String password = req.getParameter(WebConstants.PASSWORD);
        String email = req.getParameter(WebConstants.EMAIL);
        String passwordRepeat = req.getParameter(WebConstants.PASSWORD_REPEAT);
        boolean news = req.getParameter(WebConstants.NEWS) != null;
        boolean newProducts = req.getParameter(WebConstants.NEW_PRODUCTS) != null;
        req.getParameter(WebConstants.AVATAR);
        return new UserBean(name, surname, password, email, passwordRepeat, news, newProducts);
    }

    public static void loadAvatarFromRequest(HttpServletRequest req, Map<String, String> errors) {
        String filename = req.getParameter(WebConstants.EMAIL);
        String filePath = "src/main/resources";
//        if (isAvatarUploaded(req, errors)) {
            try (OutputStream out = new FileOutputStream(filePath)) {
                InputStream fileContent = req.getPart(WebConstants.AVATAR).getInputStream();
                int read;
                byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
            } catch (IOException | ServletException e) {
                errors.put(WebConstants.AVATAR, WebConstants.FILE_IS_INVALID);
            }
//        }
    }

    private static boolean isAvatarUploaded(HttpServletRequest req, Map<String, String> errors) {
        try {
            if (req.getPart(WebConstants.AVATAR).getSize() == 0) {
                return false;
            }
        } catch (IOException | ServletException e) {
            errors.put(WebConstants.AVATAR, WebConstants.FILE_IS_NOT_UPLOADED);
        }
        return true;
    }

    public static void setEnteredValuesToSession(UserBean userBean, HttpSession session) {
        session.setAttribute(WebConstants.NAME, userBean.getName());
        session.setAttribute(WebConstants.SURNAME, userBean.getSurname());
        session.setAttribute(WebConstants.EMAIL, userBean.getEmail());
        session.setAttribute(WebConstants.NEWS, userBean.getNews());
        session.setAttribute(WebConstants.NEW_PRODUCTS, userBean.getNewProducts());
    }

    public static void removeEnteredValuesFromSession(HttpSession session) {
        session.removeAttribute(WebConstants.NAME);
        session.removeAttribute(WebConstants.SURNAME);
        session.removeAttribute(WebConstants.EMAIL);
        session.removeAttribute(WebConstants.NEWS);
        session.removeAttribute(WebConstants.NEW_PRODUCTS);
        session.removeAttribute(WebConstants.ERRORS);
        session.removeAttribute(WebConstants.CAPTCHA_VALUE);
    }
}