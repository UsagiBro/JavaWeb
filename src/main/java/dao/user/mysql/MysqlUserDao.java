package dao.user.mysql;

import dao.transaction.mysql.ConnectionHolder;
import entity.User;
import exception.DBException;
import org.apache.log4j.Logger;
import service.user.MySqlUserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MysqlUserDao implements UserDao {

    private static final Logger LOG = Logger.getLogger(MySqlUserService.class);
    private static final String SQL_INSERT_USER =
            "INSERT INTO " +
                    "users (first_name, surname, password, email, news, new_products) VALUES (?,?,?,?,?,?)";
    private static final String SQL_GET_USER_BY_EMAIL_AND_PASSWORD =
            "SELECT * FROM users WHERE email = ? AND password = ?";
    private static final String SQL_USER_EXISTS = "SELECT EXISTS(SELECT * FROM users WHERE email = ?)";


    @Override
    public boolean createUser(User user) {
        Connection connection = ConnectionHolder.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER)) {
            fillPreparedStatement(preparedStatement, user.getName(),
                    user.getSurname(), user.getPassword(), user.getEmail(),
                    user.getNews(), user.getNewProducts());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException ex) {
            LOG.error(ex.getMessage());
            throw new DBException(this.getClass().getSimpleName() + "#createUser() -> DBException#" + ex);
        }
    }

    @Override
    public User readUserByEmailAndPassword(String email, String password) {
        Connection connection = ConnectionHolder.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_USER_BY_EMAIL_AND_PASSWORD)) {
            fillPreparedStatement(preparedStatement, email, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return getUserFromResultSet(resultSet);
                } else {
                    return new User();
                }
            }
        } catch (SQLException ex) {
            LOG.error(ex.getMessage());
            throw new DBException(this.getClass().getSimpleName() + "#createUser() -> DBException#" + ex);
        }
    }

    @Override
    public boolean userExists(User user) {
        boolean result = false;
        Connection connection = ConnectionHolder.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_USER_EXISTS)) {
            fillPreparedStatement(preparedStatement, user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getBoolean(1);
            }
        } catch (SQLException ex) {
            LOG.error(ex.getMessage());
            throw new DBException(this.getClass().getSimpleName() + "#userExists() -> DBException#" + ex);
        }
        return result;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setName(resultSet.getString("first_name"));
        user.setSurname(resultSet.getString("surname"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setNews(resultSet.getBoolean("news"));
        user.setNewProducts(resultSet.getBoolean("new_products"));
        return user;
    }

    private void fillPreparedStatement(PreparedStatement preparedStatement, Object... args) throws SQLException {
        int counter = 1;
        for (Object arg : args) {
            preparedStatement.setObject(counter++, arg);
        }
    }

}
