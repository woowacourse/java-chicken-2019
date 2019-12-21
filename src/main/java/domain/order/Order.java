package domain.order;

import domain.menu.Menu;

import java.util.HashMap;

public class Order {
    HashMap<Menu, Amount> order;

    public Order() {
        this.order = new HashMap<>();
    }

    public void add(Menu menu, int menuAmount) {
        Amount amount = new Amount(menuAmount);

        order.put(menu, amount);
    }

    public boolean isEmpty() {
        return order.isEmpty();
    }
}