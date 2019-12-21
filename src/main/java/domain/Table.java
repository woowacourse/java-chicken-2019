package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private List<Order> orders = new ArrayList<Order>();

    public Table(final int number) {
        this.number = number;
    }

    public boolean isTableNumberSame(int number) {

        if (number == this.number) {
            return true;
        }

        return false;
    }

    public boolean isInUse() {

        if (orders == null || orders.size() < 1) {
            return false;
        }

        return true;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
