package service.instruments;

import entity.dto.FilterBean;
import entity.dto.InstrumentsBean;

public interface InstrumentService {

    InstrumentsBean getInstrumentsByFilter(FilterBean filterBean);

    int getAllInstrumentsCount(FilterBean filterBean);
}
