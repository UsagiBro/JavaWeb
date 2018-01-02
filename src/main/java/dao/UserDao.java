package dao;

import entity.User;

public interface UserDao {

    /**
     * Inserts new user in local storage.
     * @param user entity of user to be inserted
     * @return either old user if parameter user already exists in local storage, or inserted user if not
     */
    User createUser(User user);

    /**
     * Check if such user already exists in storage.
     * @param user entity of user to be checked
     * @return true if such user already exists or false if not
     */
    boolean userExists(User user);
}
