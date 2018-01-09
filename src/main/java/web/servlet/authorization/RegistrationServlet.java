package web.servlet.authorization;

import constants.ErrorMessages;
import constants.Paths;
import constants.WebConstants;
import entity.dto.UserBean;
import exception.SuchUserExistsException;
import service.user.UserService;
import util.WebUtil;
import validator.CaptchaValidator;
import validator.UserValidator;
import web.avatar.AvatarLoader;
import web.captcha.generator_impl.CaptchaProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/registration")
@MultipartConfig
public class RegistrationServlet extends HttpServlet {

    private CaptchaProvider captchaProvider;
    private UserService userService;
    private CaptchaValidator captchaValidator;
    private UserValidator userValidator;
    private String captchaTimeOut;
    private AvatarLoader avatarLoader;

    @Override
    public void init() throws ServletException {
        captchaProvider = (CaptchaProvider) getServletContext().getAttribute(WebConstants.CAPTCHA_PROVIDER);
        userService = (UserService) getServletContext().getAttribute(WebConstants.USER_SERVICE);
        captchaValidator = new CaptchaValidator();
        userValidator = new UserValidator();
        captchaTimeOut = (String) getServletContext().getAttribute(WebConstants.CAPTCHA_TIME);
        String avatarSizeParameter = (String) getServletContext().getAttribute(WebConstants.AVATAR_SIZE);
        avatarLoader = new AvatarLoader(Long.parseLong(avatarSizeParameter));
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
                checkCaptcha(req, req.getParameter(WebConstants.CAPTCHA_VALUE));


        checkMap.putAll(checkUserBean(userBean));
        checkMap.putAll(avatarLoader.loadAvatarFromRequest(req));

        if (checkMap.isEmpty()) {
            try {
                userService.createUser(WebUtil.getUserFromUserBeanParameters(userBean));
                WebUtil.removeEnteredValuesFromSession(session);
                resp.sendRedirect(Paths.AUTHORIZATION_SERVLET);
            } catch (SuchUserExistsException e) {
                req.getSession().setAttribute(ErrorMessages.USER_EXISTS_KEY, e.getMessage());
                resp.sendRedirect(Paths.REGISTRATION_SERVLET);
            }
        } else {
            req.getSession().setAttribute(WebConstants.ERRORS, checkMap);
            resp.sendRedirect(Paths.REGISTRATION_SERVLET);
        }
    }

    private Map<String, String> checkCaptcha(HttpServletRequest req, String enteredValue) {
        return captchaValidator.validate(captchaProvider.getCaptcha(req), enteredValue, Long.parseLong(captchaTimeOut));
    }

    private Map<String, String> checkUserBean(UserBean userBean) {
        return userValidator.validate(userBean);
    }

}
