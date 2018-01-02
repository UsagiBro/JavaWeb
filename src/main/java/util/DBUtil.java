package util;

import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DBUtil {

    private DBUtil() {
        throw new IllegalStateException("Can't create an instance of a class!");
    }

    public static User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setName(resultSet.getString("first_name"));
        user.setSurname(resultSet.getString("surname"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setNews(resultSet.getBoolean("news"));
        user.setNewProducts(resultSet.getBoolean("new_products"));
        return user;
    }

    public static void fillPreparedStatement(PreparedStatement preparedStatement, Object... args) throws SQLException {
        int counter = 1;
        for (Object arg : args) {
            preparedStatement.setObject(counter++, arg);
        }
    }
}
