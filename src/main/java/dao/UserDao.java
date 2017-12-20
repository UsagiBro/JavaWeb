package dao;

import storage.entity.User;

public interface UserDao {

    void createUser(Integer id, User user);
}
