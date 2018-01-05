package web.listener;

import dao.InstrumentDao;
import dao.myslq.MysqlInstrumentDao;
import dao.transaction.mysql.MySqlTransactionManager;
import org.apache.log4j.PropertyConfigurator;
import service.instruments.InstrumentService;
import service.instruments.MySqlInstrumentService;
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
        initLog4j(servletContextEvent);
        setConstants(servletContextEvent);
        setCaptchaStrategy(servletContextEvent);
        setDatabaseForContext(servletContextEvent);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    private void setConstants(ServletContextEvent servletContextEvent) {
        String captchaTimeOut = servletContextEvent.getServletContext().getInitParameter("captcha-timeout");
        servletContextEvent.getServletContext().setAttribute(WebConstants.CAPTCHA_TIME, captchaTimeOut);

        String avatarSize = servletContextEvent.getServletContext().getInitParameter("avatar-byte-size");
        servletContextEvent.getServletContext().setAttribute(WebConstants.AVATAR_SIZE, avatarSize);
    }

    private void setCaptchaStrategy(ServletContextEvent servletContextEvent) {
        String captchaStrategy = servletContextEvent.getServletContext().getInitParameter("captcha-method");
        CaptchaStrategyGenerator captchaStrategyGenerator = new CaptchaStrategyGenerator();
        CaptchaProvider captchaGenerator = captchaStrategyGenerator.getGeneratorFromStrategy(captchaStrategy);

        servletContextEvent.getServletContext().setAttribute(WebConstants.CAPTCHA_PROVIDER, captchaGenerator);
    }

    private void setDatabaseForContext(ServletContextEvent servletContextEvent) {
        String databaseStrategy = servletContextEvent.getServletContext().getInitParameter("database-type");
        MySqlTransactionManager mySqlTransactionManager = new MySqlTransactionManager();

        UserService userService = ContextUtil.getUserServiceForContext(databaseStrategy, mySqlTransactionManager);
        servletContextEvent.getServletContext().setAttribute(WebConstants.USER_SERVICE, userService);

        InstrumentDao instrumentDao = new MysqlInstrumentDao();
        InstrumentService instrumentService = new MySqlInstrumentService(instrumentDao, mySqlTransactionManager);
        servletContextEvent.getServletContext().setAttribute(WebConstants.INSTRUMENT_SERVICE, instrumentService);
    }

    private void initLog4j(ServletContextEvent servletContextEvent) {
        PropertyConfigurator.configure(
                servletContextEvent.getServletContext().getRealPath("WEB-INF/resources/log4j.properties"));
    }

}
