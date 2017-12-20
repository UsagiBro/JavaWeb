package web.listener;

import dao.UserDao;
import dao.UserDaoImpl;
import storage.UserStorage;
import storage.entity.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserStorage userStorage = insertDefaultUsers();
        UserDao userDao = new UserDaoImpl(userStorage);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private UserStorage insertDefaultUsers() {
        UserStorage userStorage = new UserStorage();
        userStorage.createUser(1, new User("Ivan", "Gladush", "ivann"));
        userStorage.createUser(2, new User("Roman", "Piccolo", "romann"));
        userStorage.createUser(3, new User("Albert", "Albeert", "albeert"));
        return userStorage;
    }
}
