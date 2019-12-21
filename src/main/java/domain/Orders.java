package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders() {
        this.orders = new ArrayList<>();
    }

    public void add(Order order) {
        orders.add(order);
    }

    public void deleteOrder(int tableNumber) {
        for (Order order : orders) {
            if (order.isTableNumber(tableNumber)) {
                orders.remove(order);
            }
        }
    }
}
