package entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Map<Instrument, Integer> cart;

    public Cart() {
        this.cart = new HashMap<>();
    }

    public Integer addToCart(Instrument instrument) {
        if (cart.containsKey(instrument)) {
            return cart.put(instrument, cart.get(instrument) + 1);
        }
        return cart.put(instrument, 1);
    }

    public Integer removeFromCart(Instrument instrument) {
        int count = cart.get(instrument);
        if (count > 1) {
            return cart.put(instrument, --count);
        } else {
            return cart.remove(instrument);
        }
    }

    public List<Instrument> getAllInstruments() {
        return new ArrayList<>(cart.keySet());
    }

    public Integer getSize() {
        int result = 0;
        for (Integer count : cart.values()) {
            result += count;
        }
        return result;
    }

    public BigDecimal getSum() {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (Map.Entry<Instrument, Integer> entry : cart.entrySet()) {
            totalCost = totalCost.add(entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue())));
        }
        return totalCost;
    }
}
