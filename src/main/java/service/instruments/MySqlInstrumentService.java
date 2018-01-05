package service.instruments;

import dao.InstrumentDao;
import dao.transaction.mysql.MySqlTransactionManager;
import entity.Instrument;
import entity.InstrumentsBean;

import java.util.List;

public class MySqlInstrumentService implements InstrumentService {

    private InstrumentDao instrumentDao;
    private MySqlTransactionManager mySqlTransactionManager;

    public MySqlInstrumentService(InstrumentDao instrumentDao, MySqlTransactionManager mySqlTransactionManager) {
        this.instrumentDao = instrumentDao;
        this.mySqlTransactionManager = mySqlTransactionManager;
    }

    @Override
    public InstrumentsBean getAllInstruments() {
        List<Instrument> instruments = mySqlTransactionManager.processTransaction(
                () -> instrumentDao.getAllInstruments());
        return new InstrumentsBean(instruments);
    }
}
