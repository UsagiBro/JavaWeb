package web.listener;

import dao.category.CategoryDao;
import dao.instrument.InstrumentDao;
import dao.manufacturer.ManufacturerDao;
import dao.category.MysqlCategoryDao;
import dao.instrument.MysqlInstrumentDao;
import dao.manufacturer.MysqlManufacturerDao;
import dao.order.MysqlOrderDao;
import dao.order.OrderDao;
import dao.transaction.mysql.MySqlTransactionManager;
import org.apache.log4j.PropertyConfigurator;
import service.category.CategoryService;
import service.category.MysqlCategoryService;
import service.instruments.InstrumentService;
import service.instruments.MySqlInstrumentService;
import service.manufacturer.ManufacturerService;
import service.manufacturer.MysqlManufacturerService;
import service.order.MysqlOrderService;
import service.order.OrderService;
import web.captcha.CaptchaStrategyGenerator;
import web.captcha.generator_impl.CaptchaProvider;
import constants.WebConstants;
import service.user.UserService;
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

    private void setDatabaseForContext(ServletContextEvent servletContextEvent) {
        String databaseStrategy = servletContextEvent.getServletContext().getInitParameter("database-type");
        MySqlTransactionManager mySqlTransactionManager = new MySqlTransactionManager();

        UserService userService = ContextUtil.getUserServiceForContext(databaseStrategy, mySqlTransactionManager);
        servletContextEvent.getServletContext().setAttribute(WebConstants.USER_SERVICE, userService);

        InstrumentDao instrumentDao = new MysqlInstrumentDao();
        InstrumentService instrumentService = new MySqlInstrumentService(instrumentDao, mySqlTransactionManager);
        servletContextEvent.getServletContext().setAttribute(WebConstants.INSTRUMENT_SERVICE, instrumentService);

        CategoryDao categoryDao = new MysqlCategoryDao();
        CategoryService categoryService = new MysqlCategoryService(categoryDao, mySqlTransactionManager);
        servletContextEvent.getServletContext().setAttribute(WebConstants.CATEGORY_SERVICE, categoryService);

        ManufacturerDao manufacturerDao = new MysqlManufacturerDao();
        ManufacturerService manufacturerService = new MysqlManufacturerService(manufacturerDao, mySqlTransactionManager);
        servletContextEvent.getServletContext().setAttribute(WebConstants.MANUFACTURER_SERVICE, manufacturerService);

        OrderDao orderDao = new MysqlOrderDao();
        OrderService orderService = new MysqlOrderService(mySqlTransactionManager, orderDao);
        servletContextEvent.getServletContext().setAttribute(WebConstants.ORDER_SERVICE, orderService);
    }

    private void initLog4j(ServletContextEvent servletContextEvent) {
        PropertyConfigurator.configure(
                servletContextEvent.getServletContext().getRealPath("WEB-INF/resources/log4j.properties"));
    }

    private void setCaptchaStrategy(ServletContextEvent servletContextEvent) {
        String captchaStrategy = servletContextEvent.getServletContext().getInitParameter("captcha-method");
        CaptchaStrategyGenerator captchaStrategyGenerator = new CaptchaStrategyGenerator();
        CaptchaProvider captchaGenerator = captchaStrategyGenerator.getGeneratorFromStrategy(captchaStrategy);

        servletContextEvent.getServletContext().setAttribute(WebConstants.CAPTCHA_PROVIDER, captchaGenerator);
    }
}
