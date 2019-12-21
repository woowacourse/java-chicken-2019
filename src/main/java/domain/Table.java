package domain;

import java.util.List;
import java.util.Map;

public class Table {
    private final int number;
    private Ordered ordered = new Ordered();

    public Table(final int number) {
        this.number = number;
    }

    public void addMenu(Menu menu, int amount) {
        ordered.addMenu(menu, amount);
    }

    public boolean isTableNumberSame(int number) {
        return this.number == number;
    }

    public int allPrices() {
        return ordered.allPrices();
    }

    public Map<String, List<Menu>> allMenu() {
        return ordered.amountMenu();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
