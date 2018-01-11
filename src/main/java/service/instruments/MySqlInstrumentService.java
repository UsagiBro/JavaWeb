package service.instruments;

import dao.InstrumentDao;
import dao.transaction.mysql.MySqlTransactionManager;
import entity.Instrument;
import entity.dto.FilterBean;
import entity.dto.InstrumentsBean;
import util.MySqlBuilder;

import java.util.List;

public class MySqlInstrumentService implements InstrumentService {

    private InstrumentDao instrumentDao;
    private MySqlTransactionManager mySqlTransactionManager;

    public MySqlInstrumentService(InstrumentDao instrumentDao, MySqlTransactionManager mySqlTransactionManager) {
        this.instrumentDao = instrumentDao;
        this.mySqlTransactionManager = mySqlTransactionManager;
    }

    @Override
    public InstrumentsBean getInstrumentsByFilter(FilterBean filterBean) {
        List<Instrument> instruments = mySqlTransactionManager.processTransaction(
                () -> instrumentDao.getInstrumentsByFilter(filterBean));
        return new InstrumentsBean(instruments);
    }

    @Override
    public int getAllInsrumentsCount() {
        return mySqlTransactionManager.processTransaction(
                () -> instrumentDao.getAllInsrumentsCount());
    }
}
