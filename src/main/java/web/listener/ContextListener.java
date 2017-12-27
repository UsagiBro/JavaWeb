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

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        setCaptchaStrategy(servletContextEvent);
        UserStorage userStorage = insertDefaultUsers();
        UserDao userDao = new UserDaoImpl(userStorage);
        UserService userService = new UserServiceImpl(userDao);
        servletContextEvent.getServletContext().setAttribute(Constants.USER_SERVICE, userService);
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    private UserStorage insertDefaultUsers() {
        UserStorage userStorage = new UserStorage();
        userStorage.createUser(new User("Ivan", "Gladush", "ivann", "i@gladush.com",
                false, false));
        userStorage.createUser(new User("Roman", "Piccolo", "romann", "r@piccolo.com",
                false, false));
        userStorage.createUser(new User("Albert", "Albeert", "albeert", "a@lbert.com",
                false, false));
        return userStorage;
    }

    private void setCaptchaStrategy(ServletContextEvent servletContextEvent) {
        String captchaStrategy = servletContextEvent.getServletContext().getInitParameter("captcha-method");
        CaptchaStrategyGenerator captchaStrategyGenerator = new CaptchaStrategyGenerator();
        CaptchaProvider captchaGenerator = captchaStrategyGenerator.getGeneratorFromStrategy(captchaStrategy);

        servletContextEvent.getServletContext().setAttribute(Constants.CAPTCHA_PROVIDER, captchaGenerator);
    }


}
