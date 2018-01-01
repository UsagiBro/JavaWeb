package util;

import dao.UserDao;
import dao.local_storage.UserDaoLocalImpl;
import dao.myslq.UserDaoMysql;
import entity.User;
import dao.local_storage.storage.UserStorage;

public final class ContextUtil {

    public static UserStorage insertDefaultUsersLocaleStorage() {
        UserStorage userStorage = new UserStorage();
        userStorage.createUser(new User("Ivan", "Gladush", "ivann", "i@gladush.com",
                false, false));
        userStorage.createUser(new User("Roman", "Piccolo", "romann", "r@piccolo.com",
                false, false));
        userStorage.createUser(new User("Albert", "Albeert", "albeert", "a@lbert.com",
                false, false));
        return userStorage;
    }

    public static UserDao getUserServiceForContext(String databaseStrategy) {
        UserDao userDao;
        if (databaseStrategy.equals("mysql")) {
            userDao = new UserDaoMysql();
        }
        else {
            UserStorage userStorage = ContextUtil.insertDefaultUsersLocaleStorage();
            userDao = new UserDaoLocalImpl(userStorage);
        }
        return userDao;
    }
}
