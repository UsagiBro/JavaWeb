package service.instruments;

import entity.Instrument;
import entity.dto.FilterBean;
import entity.dto.InstrumentsBean;

public interface InstrumentService {

    InstrumentsBean getInstrumentsByFilter(FilterBean filterBean);

    int getAllInstrumentsCount(FilterBean filterBean);

    Instrument getInstrumentByName(String instrumentName);
}
