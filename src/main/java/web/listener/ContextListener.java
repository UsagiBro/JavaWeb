package web.listener;

import web.captcha.CaptchaStrategyGenerator;
import web.captcha.generator_impl.CaptchaProvider;
import constants.WebConstants;
import dao.UserDao;
import service.user.UserService;
import service.user.UserServiceImpl;
import util.ContextUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        setCaptchaStrategy(servletContextEvent);
        setDatabaseForContext(servletContextEvent);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    private void setCaptchaStrategy(ServletContextEvent servletContextEvent) {
        String captchaStrategy = servletContextEvent.getServletContext().getInitParameter("captcha-method");
        CaptchaStrategyGenerator captchaStrategyGenerator = new CaptchaStrategyGenerator();
        CaptchaProvider captchaGenerator = captchaStrategyGenerator.getGeneratorFromStrategy(captchaStrategy);

        servletContextEvent.getServletContext().setAttribute(WebConstants.CAPTCHA_PROVIDER, captchaGenerator);
    }

    private void setDatabaseForContext(ServletContextEvent servletContextEvent) {
        String databaseStrategy = servletContextEvent.getServletContext().getInitParameter("database-type");
        UserService userService = ContextUtil.getUserServiceForContext(databaseStrategy);
        servletContextEvent.getServletContext().setAttribute(WebConstants.USER_SERVICE, userService);
    }


}
