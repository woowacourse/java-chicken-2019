package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Table {
    private final int number;
    private int chickens = 0;
    private HashMap<String, Integer> orders = new HashMap<String, Integer>();

    public Table(final int number) {
        this.number = number;
    }

    public int getChickens() {
        return chickens;
    }

    public void addChickens() {
        chickens++;
    }

    public HashMap getOrder() {
        return orders;
    }

    public boolean tableMatch(int input) {
        return input == number;
    }

    public boolean orderExist(Menu menu) {
        return orders.containsKey(menu.getName());
    }

    public void makeOrder(Menu menu, int quantity) {
        String name = menu.getName();
        if (orderExist(menu)) {
            orders.put(name, orders.get(name) + quantity);
        }
        if (!orderExist(menu)) {
            orders.put(name, quantity);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
