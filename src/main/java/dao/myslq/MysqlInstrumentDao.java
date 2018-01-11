package dao.myslq;

import dao.InstrumentDao;
import dao.transaction.mysql.ConnectionHolder;
import entity.Instrument;
import entity.dto.FilterBean;
import exception.DBException;
import org.apache.log4j.Logger;
import util.MySqlBuilder;

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
    private static final String SQL_ALL_INSTRUMENTS_COUNT = "SELECT count(*) FROM instruments";

    @Override
    public List<Instrument> getInstrumentsByFilter(FilterBean filterBean) {
        List<Instrument> instruments = new ArrayList<>();
        MySqlBuilder mySqlBuilder = new MySqlBuilder();
        Connection connection = ConnectionHolder.getConnection();
        String query = mySqlBuilder.buildQuery(filterBean);
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    instruments.add(getInstrumentFromResultSet(resultSet));
                }
            }
        } catch (SQLException ex) {
            LOG.error(ex.getMessage());
            throw new DBException(this.getClass().getSimpleName() + "#getAllInstrumentsByFilter() -> DBException#" + ex);
        }
        return instruments;
    }

    @Override
    public int getAllInsrumentsCount() {
        int result = 0;
        Connection connection = ConnectionHolder.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_ALL_INSTRUMENTS_COUNT)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    result = resultSet.getInt(1);
                }
            }
        } catch (SQLException ex) {
            LOG.error(ex.getMessage());
            throw new DBException(this.getClass().getSimpleName() + "#getAllInstrumentsCount() -> DBException#" + ex);
        }
        return result;
    }

    private Instrument getInstrumentFromResultSet(ResultSet resultSet) throws SQLException {
        Instrument instrument = new Instrument();
        instrument.setName(resultSet.getString("ins_name"));
        instrument.setPrice(resultSet.getBigDecimal("price"));
        instrument.setCategory(resultSet.getString("label"));
        instrument.setManufacturer(resultSet.getString("title"));
        return instrument;
    }
}
