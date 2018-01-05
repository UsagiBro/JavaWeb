package entity;

import java.util.List;

public class InstrumentsBean {

    private List<Instrument> instruments;

    public InstrumentsBean(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }


    public void filter(Object... filters) {

    }
}
