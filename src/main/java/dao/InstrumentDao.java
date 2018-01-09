package dao;

import entity.Instrument;
import entity.dto.FilterBean;

import java.util.List;

public interface InstrumentDao {

    List<Instrument> getAllInstruments();

    List<Instrument> getInstrumentsByFilter(FilterBean filterBean);
}
