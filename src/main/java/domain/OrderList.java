package domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class OrderList {
    private static final List<Order> orders = new ArrayList<>();

    public static void addOrder(Order order) {
        orders.add(order);
    }

    public static List<Order> search(int tableNumber, int menuNumber) {
        List<Order> findOrders = new ArrayList<>();

        for (Order order : orders) {
            if (order.isTableNumber(tableNumber) && order.isMenuNumber(menuNumber)) {
                findOrders.add(order);
            }
        }

        return Collections.unmodifiableList(findOrders);
    }

    public static List<Order> orders() {
        return Collections.unmodifiableList(orders);
    }



}
