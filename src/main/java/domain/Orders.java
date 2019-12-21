package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {

    private static final int ORDER_NOTHING = 0;

    private List<Order> orders;

    public Orders() {
        this.orders = new ArrayList<>();
    }

    public void addOrder( Order order ) {
        orders.add(order);
    }

    public int getOrderSize() {
        return orders.size();
    }

    public int getAmount() {
        int amount = 0;
        for (Order order : orders) {
            Menu current = MenuRepository.getMenu(order.number);
            amount += current.getPrice(order.quantity);
        }
        return amount;
    }

    public boolean orderNothing() {
        return orders.isEmpty();
    }

    public void clearOrder() {
        this.orders = new ArrayList<>();
    }

    @Override
    public String toString() {
        return orders.stream().map(Order::toString).collect(Collectors.joining(", "));
    }
}
