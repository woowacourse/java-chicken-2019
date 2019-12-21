package domain;

import java.util.List;
import java.util.Map;

public class Table {
    private final int number;
    private Ordered ordered = new Ordered();

    public Table(final int number) {
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    public void addMenu(Menu menu, int amount) {
        ordered.addMenu(menu, amount);
    }

    boolean isTableNumberSame(int number) {
        return this.number == number;
    }

    int allPrices() {
        return ordered.allPrices();
    }

    public int countOfMenu(Menu menu) {
        return ordered.countOfMenu(menu);
    }

    public boolean isOrdered() {
        return ordered.isNotEmpty();
    }

    public Map<String, List<Menu>> allMenu() {
        return ordered.amountMenu();
    }

    public void removeAllOrdered() {
        ordered = new Ordered();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
