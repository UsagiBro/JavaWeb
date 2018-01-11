package service.instruments;

import entity.dto.FilterBean;
import entity.dto.InstrumentsBean;

public interface InstrumentService {

//    InstrumentsBean getAllInstruments();

    InstrumentsBean getInstrumentsByFilter(FilterBean filterBean);

    int getAllInsrumentsCount();
}
