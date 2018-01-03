package web.listener;

import captcha.CaptchaStrategyGenerator;
import captcha.generator_impl.CaptchaProvider;
import constants.Constants;
import dao.UserDao;
import dao.local_storage.UserDaoImpl;
import entity.User;
import service.user.UserService;
import service.user.UserServiceImpl;
import storage.UserStorage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        setService(servletContextEvent);
        setCaptchaStrategy(servletContextEvent);
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    private void setService(ServletContextEvent servletContextEvent) {
        UserStorage userStorage = new UserStorage();
        UserDao userDao = new UserDaoImpl(userStorage);
        UserService userService = new UserServiceImpl(userDao);
        userService.createUser(new User("Ivan", "Gladush", "ivann", "i@gladush.com",
                false, false));
        userService.createUser(new User("Roman", "Piccolo", "romann", "r@piccolo.com",
                false, false));
        userService.createUser(new User("Albert", "Albeert", "albeert", "a@lbert.com",
                false, false));
        servletContextEvent.getServletContext().setAttribute(Constants.USER_SERVICE, userService);
    }

    /**
     * Receives entity of captcha generator related on which key is entered in web.xml
     *
     * @param servletContextEvent event class for notifications about changes to the servlet context of
     *                            a web application
     */
    private void setCaptchaStrategy(ServletContextEvent servletContextEvent) {
        String captchaStrategy = servletContextEvent.getServletContext().getInitParameter("captcha-method");
        CaptchaStrategyGenerator captchaStrategyGenerator = new CaptchaStrategyGenerator();
        CaptchaProvider captchaGenerator = captchaStrategyGenerator.getGeneratorFromStrategy(captchaStrategy);

        String captchaTimeOut = servletContextEvent.getServletContext().getInitParameter("captcha-timeout");
        servletContextEvent.getServletContext().setAttribute(Constants.CAPTCHA_TIME, captchaTimeOut);
        servletContextEvent.getServletContext().setAttribute(Constants.CAPTCHA_PROVIDER, captchaGenerator);
    }


}
