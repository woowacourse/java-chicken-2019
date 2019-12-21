package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Table {
    private final int number;
    private int moneyCharged = 0;
    private HashMap<Menu, Integer> menuOrdered = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return this.number;
    }

    public void orderMenu(Menu menu, int quantity) {
        this.menuOrdered.put(menu, menuOrdered.getOrDefault(menu, 0)+quantity);
    }

    public HashMap<Menu, Integer> getMenuOrdered() {
        return this.menuOrdered;
    }

    public boolean hasOrdered() {
        if (menuOrdered.isEmpty()) return false;
        return true;
    }

}
