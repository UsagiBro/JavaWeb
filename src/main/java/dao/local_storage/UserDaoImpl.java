package dao.local_storage;

import dao.UserDao;
import entity.User;
import storage.UserStorage;

public class UserDaoImpl implements UserDao {

    private UserStorage userStorage;

    public UserDaoImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    /**
     * Inserts new user in local storage.
     * @param user entity of user to be inserted
     * @return either old user if parameter user already exists in local storage, or inserted user if not
     */
    @Override
    public User createUser(User user) {
        return userStorage.createUser(user);
    }

    /**
     * Check if such user already exists in storage.
     * @param user entity of user to be checked
     * @return true if such user already exists or false if not
     */
    @Override
    public boolean userExists(User user) {
        return userStorage.contains(user);
    }
}
