package dao.myslq;

import dao.ConnectionHolder;
import dao.UserDao;
import entity.User;
import exception.DBException;
import org.apache.log4j.Logger;
import service.user.UserServiceMySql;
import util.DBUtil;

import java.sql.*;


public class UserDaoMysql implements UserDao {

    private static final Logger LOG = Logger.getLogger(UserServiceMySql.class);
    private static final String SQL_INSERT_USER =
            "INSERT INTO " +
                    "users (first_name, surname, password, email, news, new_products) VALUES (?,?,?,?,?,?)";
    private static final String SQL_GET_USER_BY_EMAIL_AND_PASSWORD =
            "SELECT * FROM users WHERE email = ? AND password = ?";


    @Override
    public boolean createUser(User user) {
        Connection connection = ConnectionHolder.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER)) {
            DBUtil.fillPreparedStatement(preparedStatement, user.getName(),
                    user.getSurname(), user.getPassword(), user.getEmail(),
                    user.getNews(), user.getNewProducts());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOG.error(ex.getMessage());
            throw new DBException(this.getClass().getSimpleName() + "#createUser() -> DBException#" + ex);
        }
    }

    @Override
    public User readUserByEmailAndPassword(String email, String password) {
        Connection connection = ConnectionHolder.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_USER_BY_EMAIL_AND_PASSWORD)) {
            DBUtil.fillPreparedStatement(preparedStatement, email, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return DBUtil.getUserFromResultSet(resultSet);
                }
            }
        } catch (SQLException ex) {
            LOG.error(ex.getMessage());
            throw new DBException(this.getClass().getSimpleName() + "#createUser() -> DBException#" + ex);
        }
        return null;
    }


}
