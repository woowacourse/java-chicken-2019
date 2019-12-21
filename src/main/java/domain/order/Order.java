package domain.order;

import domain.menu.Menu;

import java.util.HashMap;

public class Order {
    HashMap<Menu, Amount> order;

    public Order() {
        this.order = new HashMap<>();
    }

    public void add(Menu menu, int menuAmount) throws IllegalArgumentException {
        if (orderedBefore(menu)) {
            Amount amount = order.get(menu);
            amount.add(menuAmount);
        }
        Amount amount = new Amount(menuAmount);
        order.put(menu, amount);
    }

    private boolean orderedBefore(Menu menu) {
        return order.containsKey(menu);
    }

    public boolean isEmpty() {
        return order.isEmpty();
    }
}