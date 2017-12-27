package dao;

import entity.User;

public interface UserDao {

    User createUser(User user);

    boolean userExists(User user);
}
