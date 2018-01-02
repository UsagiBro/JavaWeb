package web.listener;

import captcha.CaptchaStrategyGenerator;
import captcha.generator_impl.CaptchaProvider;
import constants.Constants;
import dao.UserDao;
import dao.local_storage.UserDaoImpl;
import service.user.UserService;
import service.user.UserServiceImpl;
import storage.UserStorage;
import entity.User;
import util.ContextUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        setCaptchaStrategy(servletContextEvent);
        UserStorage userStorage = ContextUtil.insertDefaultUsers();
        UserDao userDao = new UserDaoImpl(userStorage);
        UserService userService = new UserServiceImpl(userDao);
        servletContextEvent.getServletContext().setAttribute(Constants.USER_SERVICE, userService);
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    /**
     * Receives entity of captcha generator related on which key is entered in web.xml
     * @param servletContextEvent event class for notifications about changes to the servlet context of
     *                            a web application
     */
    private void setCaptchaStrategy(ServletContextEvent servletContextEvent) {
        String captchaStrategy = servletContextEvent.getServletContext().getInitParameter("captcha-method");
        CaptchaStrategyGenerator captchaStrategyGenerator = new CaptchaStrategyGenerator();
        CaptchaProvider captchaGenerator = captchaStrategyGenerator.getGeneratorFromStrategy(captchaStrategy);

        servletContextEvent.getServletContext().setAttribute(Constants.CAPTCHA_PROVIDER, captchaGenerator);
    }


}
