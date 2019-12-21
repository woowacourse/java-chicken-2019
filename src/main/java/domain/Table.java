package domain;

import java.util.HashMap;
import java.util.Map;

public class Table  extends StoreTool{
    private final Bills bills = new Bills();

    public Table(final int number) {
        this.number = number;
    }

    public void addOrder(Menu menu, int quantity) {
        bills.add(menu, quantity);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
