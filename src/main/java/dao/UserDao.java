package dao;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    boolean createUser(User user);

    User readUserByEmailAndPassword(String email, String password);

    boolean userExists(User user);
}
