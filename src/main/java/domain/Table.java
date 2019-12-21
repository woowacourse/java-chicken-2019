package domain;

import java.util.HashMap;

public class Table {
    private static final int ZERO = 0;

    private final int number;
    private final HashMap<Menu, Integer> bill = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public boolean isSameTableNumber(int number) {
        return this.number == number;
    }

    public void addMenu(Menu menu, int mount) {
        if (isOrderMenu(menu)) {
            bill.replace(menu, mount);
            return;
        }
        bill.put(menu, mount);
    }

    private boolean isOrderMenu(Menu menu) {
        return bill.containsKey(menu);
    }

    public boolean hasMenu() {
        return bill.size() != ZERO;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
