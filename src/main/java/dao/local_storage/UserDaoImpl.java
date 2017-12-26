package dao.local_storage;

import dao.UserDao;
import storage.entity.User;
import storage.UserStorage;

public class UserDaoImpl implements UserDao {

    private UserStorage userStorage;

    public UserDaoImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public boolean createUser(User user) {
        return userStorage.createUser(user);
    }
}
