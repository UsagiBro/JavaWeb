package util;

import entity.User;
import storage.UserStorage;

public final class ContextUtil {

    private ContextUtil() {
        throw new IllegalStateException("Can't create an instance");
    }

    /**
     * Used for input default values into local storage
     * @return entity of user storage with inputted values
     */
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
