package dao.myslq;

import dao.InstrumentDao;
import dao.transaction.mysql.ConnectionHolder;
import entity.Instrument;
import exception.DBException;
import org.apache.log4j.Logger;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlInstrumentDao implements InstrumentDao {

    private static final Logger LOG = Logger.getLogger(MysqlInstrumentDao.class);
    private static final String SQL_SELECT_ALL_INSTRUMENTS = "SELECT i.ins_name, i.price, c.label, m.title " +
            "FROM instruments i JOIN categories c ON i.category_id=c.id " +
            "JOIN manufacturers m ON i.manufacturer_id=m.id";

    @Override
    public List<Instrument> getAllInstruments() {
        List<Instrument> instruments = new ArrayList<>();
        Connection connection = ConnectionHolder.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_INSTRUMENTS)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    instruments.add(DBUtil.getInstrumentFromResultSet(resultSet));
                }
            }
        } catch (SQLException ex) {
            LOG.error(ex.getMessage());
            throw new DBException(this.getClass().getSimpleName() + "#getAllInstruments() -> DBException#" + ex);
        }
        return instruments;
    }
}
