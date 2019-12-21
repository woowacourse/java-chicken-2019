package domain;

import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    final static int CASH = 2;
    final static int CASH_DISCOUNT_PERCENT = 5;
    private List<Order> orders = new ArrayList<Order>();

    public Bill() {
    }

    public void updateBill(Order order) {
        orders.add(order);
    }

    public boolean hasOrders() {
        return orders.size() > 0;
    }

    public void showOrders() {
        for (Order order : orders) {
            OutputView.printOrder(order);
        }
    }

    public int calTotal(int paymentMethod) {
        int total = 0;
        for (Order order : orders) {
            total += order.price();
        }

        if (paymentMethod == CASH) {
            total -= cashDiscount(total);
        }
        OutputView.printTotalPrice(total);
        return total;
    }

    public int cashDiscount(int total) {
        return (total * CASH_DISCOUNT_PERCENT) / 100;
    }
}
