package domain;

import java.util.List;

public class Table {
    private final int number;

    private Orders orders = Orders.emptyOrders();

    public Table(final int number) {
        this.number = number;
    }

    public boolean equalId(int id) {
        return number == id;
    }

    public void addOrders(List<Menu> list) {
        this.orders.addMenu(list);
    }

    public boolean hasNotOrders() {
        return orders.isEmpty();
    }

    public void clear() {
        this.orders.clear();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
