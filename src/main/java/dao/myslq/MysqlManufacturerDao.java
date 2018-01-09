package dao.myslq;

import dao.ManufacturerDao;
import dao.transaction.mysql.ConnectionHolder;
import entity.dto.Manufacturer;
import exception.DBException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlManufacturerDao implements ManufacturerDao {

    private static final String SQL_SELECT_ALL_MANUFACTURERS = "SELECT * FROM manufacturers";

    private static final Logger LOG = Logger.getLogger(MysqlManufacturerDao.class);

    @Override
    public List<Manufacturer> getAllManufacturers() {
        Connection connection = ConnectionHolder.getConnection();
        List<Manufacturer> manufacturers = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_MANUFACTURERS)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Manufacturer manufacturer = new Manufacturer();
                    manufacturer.setId(resultSet.getInt("id"));
                    manufacturer.setTitle(resultSet.getString("title"));
                    manufacturers.add(manufacturer);
                }
            }
        } catch (SQLException ex) {
            LOG.error(ex.getMessage());
            throw new DBException(this.getClass().getSimpleName() + "#getAllManufacturers() -> DBException#" + ex);
        }
        return manufacturers;
    }
}
