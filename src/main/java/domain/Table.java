package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Table {

    private final int number;
    private final Map<Menu, Integer> orderHistory = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public void registerMenu(Menu menu, int menuCount) {
        if (!orderHistory.containsKey(menu)) {
            orderHistory.put(menu, 0);
        }
        orderHistory.put(menu, orderHistory.get(menu) + menuCount);
    }

    public Map<Menu, Integer> getOrderHistory() {
        return Collections.unmodifiableMap(orderHistory);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isNumber(int number) {
        return this.number == number;
    }
}
