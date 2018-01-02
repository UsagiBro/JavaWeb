package util;

import entity.User;
import storage.UserStorage;

public class ContextUtil {

    public static UserStorage insertDefaultUsers() {
        UserStorage userStorage = new UserStorage();
        userStorage.createUser(new User("Ivan", "Gladush", "ivann", "i@gladush.com",
                false, false));
        userStorage.createUser(new User("Roman", "Piccolo", "romann", "r@piccolo.com",
                false, false));
        userStorage.createUser(new User("Albert", "Albeert", "albeert", "a@lbert.com",
                false, false));
        return userStorage;
    }
}
