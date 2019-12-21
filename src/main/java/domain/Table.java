package domain;

import java.util.HashMap;
import java.util.List;

public class Table {
    private final int number;
    private final int MAX_ORDER = 99;

    private Order order;

    public Table(final int number) {
        this.number = number;
    }

    public void addOrder(Menu menu, int amount) {
        if(!hasOrder()) {
            HashMap<Menu, Integer> newOrder = new HashMap<>();
            newOrder.put(menu, amount);
            this.order = new Order(newOrder);
        }
        if(hasOrder()) {
            this.order = order.addNewOrder(menu, amount);
        }
    }

    public boolean isCorrectTable(int tableNumber) {
        return this.number == tableNumber;
    }

    public boolean hasOrder() {
        return !(order == null);
    }

    public Price calculatePrice() {
        return order.PriceInfo();
    }

    public void clearTable() {
        order = null;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public String orderToString() {
        return order.toString();
    }
}
