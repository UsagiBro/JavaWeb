package dao.myslq;

import dao.UserDao;
import entity.User;


public class UserDaoMysql implements UserDao {

    private static final String SQL_INSERT_USER = "INSERT INTO users VALUES (?, ?, ?, DEFAULT, DEFAULT)";
    private static final String SQL_GET_USER_BY_LOGIN_AND_PASSWORD =
            "SELECT * FROM users WHERE login = ? AND password = ?";


    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public boolean userExists(User user) {
        return false;
    }

    @Override
    public User readUserByLoginAndPassword(String login, String password) {
        return null;
    }


}
