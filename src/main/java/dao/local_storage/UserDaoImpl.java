package dao.local_storage;

import dao.UserDao;
import entity.User;
import storage.UserStorage;

public class UserDaoImpl implements UserDao {

    private UserStorage userStorage;

    public UserDaoImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public User createUser(User user) {
        return userStorage.createUser(user);
    }

    @Override
    public boolean userExists(User user) {
        return userStorage.contains(user);
    }
}
