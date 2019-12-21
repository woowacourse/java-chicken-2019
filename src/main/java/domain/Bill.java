package domain;

import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Bill {
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
}
