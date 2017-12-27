package web.servlet;

import captcha.generator_impl.CaptchaProvider;
import constants.Constants;
import entity.UserBean;
import exception.CaptchaNotValidException;
import exception.SuchUserExistsException;
import service.user.UserService;
import entity.User;
import service.validator.CaptchaValidator;
import service.validator.UserValidator;
import web.Paths;
import web.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private CaptchaProvider captchaProvider;
    private UserService userService;
    private CaptchaValidator captchaValidator;
    private UserValidator userValidator;

    @Override
    public void init() throws ServletException {
        captchaProvider = (CaptchaProvider) getServletContext().getAttribute(Constants.CAPTCHA_PROVIDER);
        userService = (UserService) getServletContext().getAttribute(Constants.USER_SERVICE);
        captchaValidator = new CaptchaValidator();
        userValidator = new UserValidator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Paths.REGISTRATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        UserBean userBean = WebUtil.getUserBeanFromRequest(req);
        WebUtil.setEnteredValuesToSession(userBean, session);

        Map<String, String> checkMap =
                checkCaptcha(req, req.getParameter(Constants.CAPTCHA_VALUE));


        checkMap.putAll(checkUserBean(userBean));

        if (checkMap.isEmpty()) {
            try {
                userService.createUser(WebUtil.getUserFromUserBeanParameters(userBean));
                WebUtil.removeEnteredValuesFromSession(session);
                resp.sendRedirect(Paths.AUTHORIZATION_HTML);
            } catch (SuchUserExistsException e) {
                req.getSession().setAttribute(Constants.USER_EXISTS_KEY, e.getMessage());
                resp.sendRedirect(Paths.REGISTRATION_SERVLET);
            }
        } else {
            req.getSession().setAttribute(Constants.ERRORS, checkMap);
            resp.sendRedirect(Paths.REGISTRATION_SERVLET);
        }
    }

    private Map<String, String> checkCaptcha(HttpServletRequest req, String enteredValue) {
        Map<String, String> res = new HashMap<>();
        try {
            res = captchaValidator.validate(captchaProvider.getCaptcha(req), enteredValue);
        } catch (CaptchaNotValidException e) {
            res.put(Constants.CAPTCHA, e.getMessage());
        }
        return res;
    }

    private Map<String, String> checkUserBean(UserBean userBean) {
        return userValidator.validate(userBean);
    }

}
