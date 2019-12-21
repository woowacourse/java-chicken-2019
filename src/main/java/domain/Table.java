package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private Map<Integer, Integer> orderMenu = new HashMap<Integer, Integer>();

    public Table(final int number) {
        this.number = number;
    }

    public void addOrderMenu(int menuNumber, int quantityNumber) {
        int asIsQuantityNumber = 0;
        if (orderMenu.containsKey(menuNumber)) {
            asIsQuantityNumber = orderMenu.get(menuNumber);
        }
        orderMenu.put(menuNumber, asIsQuantityNumber + quantityNumber);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
