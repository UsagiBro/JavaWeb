package util;

import dao.UserDao;
import dao.local_storage.UserDaoLocalImpl;
import dao.myslq.MysqlUserDao;
import dao.transaction.mysql.MySqlTransactionManager;
import entity.User;
import dao.local_storage.storage.UserStorage;
import service.instruments.InstrumentService;
import service.user.UserService;
import service.user.UserServiceImpl;
import service.user.MySqlUserService;

public final class ContextUtil {

    private ContextUtil() {
        throw new IllegalStateException("Can't create an instance of this class");
    }


    public static UserService getUserServiceForContext(String databaseStrategy,
                                                       MySqlTransactionManager mySqlTransactionManager) {
        UserService userService;
        if (databaseStrategy.equals("mysql")) {
            UserDao userDao = new MysqlUserDao();
            userService = new MySqlUserService(mySqlTransactionManager, userDao);
        }
        else {
            UserStorage userStorage = new UserStorage();
            UserDao userDao = new UserDaoLocalImpl(userStorage);
            userService = new UserServiceImpl(userDao);
            userService.createUser(new User("Ivan", "Gladush", "ivann", "i@gladush.com",
                    false, false));
            userService.createUser(new User("Roman", "Piccolo", "romann", "r@piccolo.com",
                    false, false));
            userService.createUser(new User("Albert", "Albeert", "albeert", "a@lbert.com",
                    false, false));
        }
        return userService;
    }
}
