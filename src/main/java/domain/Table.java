package domain;

public class Table {
    private final int number;

    private Orders orders = Orders.emptyOrders();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
