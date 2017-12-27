package web.servlet;

import captcha.Captcha;
import captcha.generator_impl.CaptchaProvider;
import constants.Constants;
import service.captcha.CaptchaService;
import service.captcha.CaptchaServiceImpl;
import service.user.UserService;
import storage.entity.User;
import web.Paths;
import web.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private CaptchaProvider captchaProvider;
    private UserService userService;
    private CaptchaService captchaService;

    @Override
    public void init() throws ServletException {
        captchaProvider = (CaptchaProvider) getServletContext().getAttribute(Constants.CAPTCHA_PROVIDER);
        userService = (UserService) getServletContext().getAttribute(Constants.USER_SERVICE);
        captchaService = new CaptchaServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Paths.REGISTRATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = WebUtil.getUserParameters(req);
        WebUtil.setEnteredValuesToSession(user, session);

        if (checkCaptcha(req.getParameter(Constants.CAPTCHA_VALUE), req)) {
            if (createUser(user, req)) {
                WebUtil.removeEnteredValuesFromSession(session);
                resp.sendRedirect(Paths.AUTHORIZATION_HTML);
            } else {
                resp.sendRedirect(Paths.REGISTRATION_SERVLET);
            }
        } else {
            resp.sendRedirect(Paths.REGISTRATION_SERVLET);
        }
    }

    private boolean createUser(User user, HttpServletRequest req) {
        boolean result;
        result = userService.createUser(user);
        req.getSession().setAttribute(Constants.ERRORS, userService.getErrors());
        return result;
    }

    private boolean checkCaptcha(String captchaValue, HttpServletRequest req) {
        boolean result;
        Captcha captcha = captchaProvider.getCaptcha(req);
        result = captchaService.checkCaptcha(captcha, captchaValue);
        req.getSession().setAttribute(Constants.ERRORS, captchaService.getErrors());
        return result;
    }

}
