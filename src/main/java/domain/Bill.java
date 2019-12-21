package domain;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Order> orders = new ArrayList<Order>();

    public Bill() {
    }

    public void updateBill(Order order) {
        orders.add(order);
    }
}
