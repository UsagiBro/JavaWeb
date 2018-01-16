package dao.order;

import dao.transaction.mysql.ConnectionHolder;
import entity.order.Order;
import exception.DBException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlOrderDao implements OrderDao {

    private static final Logger LOG = Logger.getLogger(MysqlOrderDao.class);
    private static final String SQL_INSERT_ORDER = "";

    @Override
    public boolean createOrder(Order order) {
        Connection connection = ConnectionHolder.getConnection();
        boolean result;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_ORDER)) {
                result = preparedStatement.executeUpdate() == 1;
        } catch (SQLException ex) {
            LOG.error(ex.getMessage());
            throw new DBException(this.getClass().getSimpleName() + "#createOrder() -> DBException#" + ex);
        }
        return result;
    }
}
