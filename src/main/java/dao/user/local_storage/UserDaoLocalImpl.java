package dao.user.local_storage;

import dao.user.mysql.UserDao;
import entity.User;
import dao.user.local_storage.storage.UserStorage;

public class UserDaoLocalImpl implements UserDao {

    private UserStorage userStorage;

    public UserDaoLocalImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public boolean createUser(User user) {
        return userStorage.createUser(user);
    }

    @Override
    public User readUserByEmailAndPassword(String login, String password) {
        return null;
    }

    @Override
    public boolean userExists(User user) {
        return userStorage.contains(user);
    }
}
