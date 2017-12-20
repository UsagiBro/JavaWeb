package dao;

import storage.entity.User;
import storage.UserStorage;

public class UserDaoImpl implements UserDao {

    private UserStorage userStorage;

    public UserDaoImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void createUser(Integer id, User user) {
        userStorage.getUsers().put(id, user);
    }
}
