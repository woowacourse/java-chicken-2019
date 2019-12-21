package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private static final int ZERO = 0;

    private final TableNumber number;
    private final HashMap<Menu, Integer> bill = new HashMap<>();

    public Table(final int number) {
        this.number = new TableNumber(number);
    }

    public boolean isSameTableNumber(int number) {
        return this.number.getNumber() == number;
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

    public HashMap<Menu, Integer> getBill() {
        return bill;
    }

    public int getNumber() {
        return number.getNumber();
    }

    public int getTotalPrice() {
        int price = 0;
        for (Map.Entry<Menu, Integer> entry : bill.entrySet()) {
            price += entry.getKey().getPrice() * entry.getValue();
        }
        return price;
    }

    public int getTotalAmount() {
        int amount = 0;
        for (int entry : bill.values()) {
            amount += entry;
        }
        return amount;
    }

    public void clearBill() {
        bill.clear();
    }

    @Override
    public String toString() {
        return Integer.toString(number.getNumber());
    }
}
