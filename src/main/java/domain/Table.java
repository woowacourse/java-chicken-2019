package domain;

import java.util.HashMap;

public class Table {
    private final int number;
    private HashMap<Menu, Integer> orderMenu = new HashMap<>();
    private int money = 0;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public HashMap<Menu, Integer> getOrderMenu() {
        return orderMenu;
    }
}
