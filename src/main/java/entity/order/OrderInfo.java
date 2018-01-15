package entity.order;

import entity.Instrument;

import java.math.BigDecimal;

public final class OrderInfo {

    private Instrument instrument;

    private int instrumentCount;

    private BigDecimal instrumentPrice;

    public OrderInfo(Instrument instrument, int instrumentCount, BigDecimal instrumentPrice) {
        this.instrument = instrument;
        this.instrumentCount = instrumentCount;
        this.instrumentPrice = instrumentPrice;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public int getInstrumentCount() {
        return instrumentCount;
    }

    public BigDecimal getInstrumentPrice() {
        return instrumentPrice;
    }



}
