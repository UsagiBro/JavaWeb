package dao.myslq;

import dao.ConnectionHolder;
import dao.UserDao;
import entity.User;
import exception.DBException;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoMysql implements UserDao {

    private static final String SQL_INSERT_USER = "INSERT INTO users VALUES (?,?, ?, ?, DEFAULT, DEFAULT)";
    private static final String SQL_GET_USER_BY_LOGIN_AND_PASSWORD =
            "SELECT * FROM users WHERE email = ? AND password = ?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM users";


    @Override
    public boolean createUser(User user) {
        Connection connection = ConnectionHolder.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER)) {
            DBUtil.fillPreparedStatement(preparedStatement, user.getName(),
                    user.getSurname(), user.getPassword(), user.getEmail());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public List<User> readAllUsers() {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionHolder.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()) {
                users.add(DBUtil.getUserFromResultSet(resultSet));
            }
        } catch (SQLException ex) {

        }
        return users;
    }

    @Override
    public User readUserByEmailAndPassword(String email, String password) {
        Connection connection = ConnectionHolder.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_USER_BY_LOGIN_AND_PASSWORD)) {
            DBUtil.fillPreparedStatement(preparedStatement, email, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return DBUtil.getUserFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new DBException("Can't get user by login and password!");
        }
        return null;
    }


}
