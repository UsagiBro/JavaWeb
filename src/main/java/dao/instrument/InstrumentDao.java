package dao.instrument;

import entity.Instrument;
import entity.dto.FilterBean;

import java.util.List;

public interface InstrumentDao {

    List<Instrument> getInstrumentsByFilter(FilterBean filterBean);

    int getAllInstrumentsCount(FilterBean filterBean);

    Instrument getInstrumentByName(String instrumentName);
}
