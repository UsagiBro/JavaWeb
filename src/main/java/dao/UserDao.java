package dao;

import storage.entity.User;
import storage.UserStorage;

public class UserDao {

    private UserStorage userStorage;

    public UserDao(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void createUser(Integer id, User user) {
        userStorage.getUsers().put(id, user);
    }
}
