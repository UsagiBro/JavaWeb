package dao.category;

import dao.transaction.mysql.ConnectionHolder;
import entity.dto.Category;
import exception.DBException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlCategoryDao implements CategoryDao {

    private static final String SQL_SELECT_ALL_CATEGORIES = "SELECT * FROM categories";

    private static final Logger LOG = Logger.getLogger(MysqlCategoryDao.class);

    @Override
    public List<Category> getAllCategories() {
        Connection connection = ConnectionHolder.getConnection();
        List<Category> categories = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_CATEGORIES)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Category category = new Category();
                    category.setId(resultSet.getInt("id"));
                    category.setLabel(resultSet.getString("label"));
                    categories.add(category);
                }
            }
        } catch (SQLException ex) {
            LOG.error(ex.getMessage());
            throw new DBException(this.getClass().getSimpleName() + "#getAllCategories() -> DBException#" + ex);
        }
        return categories;
    }
}
