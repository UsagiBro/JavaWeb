package dao;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    boolean createUser(User user);

    List<User> readAllUsers();

    User readUserByEmailAndPassword(String email, String password);
}
