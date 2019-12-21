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

    public int getMoneyCharged() {
        return this.moneyCharged;
    }

    public HashMap<Menu, Integer> getMenuOrdered() {
        return this.menuOrdered;
    }

    public void orderMenu(Menu menu, int quantity) {
        this.menuOrdered.put(menu, menuOrdered.getOrDefault(menu, 0)+quantity);
        addMoneyCharged(quantity*menu.getPrice());
    }



    public boolean hasOrdered() {
        if (menuOrdered.isEmpty()) return false;
        return true;
    }

    public void addMoneyCharged(int money) {
        this.moneyCharged+=money;
    }



}
