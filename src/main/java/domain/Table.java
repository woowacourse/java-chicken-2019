package domain;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void cleanOrders() {
        orders.clear();
    }

    public int getTotalPayment() {
        int totalPayment = 0;

        for (Order order : orders) {
            totalPayment += getPaymentAboutOneProduct(order);
        }

        return totalPayment;
    }

    private int getPaymentAboutOneProduct(Order order) {
        int payment = 0;

        for (int i = 0; i < order.getOrderQuantity(); i++) {
            payment += order.getMenu().getPrice();
        }

        return payment;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
