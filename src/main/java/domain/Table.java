package domain;

public class Table {
    private final int number;

    private Orders orders = Orders.emptyOrders();

    public Table(final int number) {
        this.number = number;
    }

    public boolean equalId(int id) {
        return number == id;
    }

    public void addOrder(Order order) {
        this.orders.addMenu(order);
    }

    public boolean hasNotOrders() {
        return orders.isEmpty();
    }

    public void clear() {
        this.orders.clear();
    }

    public Orders getOrders() {
        return this.orders;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
