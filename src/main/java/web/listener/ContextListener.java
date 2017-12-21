package web.listener;

import dao.UserDao;
import dao.UserDaoImpl;
import service.UserService;
import service.UserServiceImpl;
import storage.UserStorage;
import storage.entity.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserStorage userStorage = insertDefaultUsers();
        UserDao userDao = new UserDaoImpl(userStorage);
        UserService userService = new UserServiceImpl(userDao);
        servletContextEvent.getServletContext().setAttribute("userService", userService);

    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    private UserStorage insertDefaultUsers() {
        UserStorage userStorage = new UserStorage();
        userStorage.createUser(new User("Ivan", "Gladush", "ivann", "i@gladush.com"));
        userStorage.createUser(new User("Roman", "Piccolo", "romann", "r@piccolo.com"));
        userStorage.createUser(new User("Albert", "Albeert", "albeert", "a@lbert.com"));
        return userStorage;
    }
}
