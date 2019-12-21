package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private static final int ORDER_NOTHING = 0;

    private final int number;
    private static final Orders orders = new Orders();

    public Table(final int number) {
        this.number = number;
    }

    public static void addOrder( Order order) {
        orders.addOrder(order);
    }

    public boolean hasOrder() {
        return !orders.orderNothing();
    }

    public int getNumber() {
        return number;
    }

    public int getAmount() {
        return orders.getAmount();
    }

    public int getOrderSize() {
        return orders.getOrderSize();
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
