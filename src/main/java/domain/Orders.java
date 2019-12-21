package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Orders {

    private static final int ORDER_NOTHING = 0;

    private static final List<Order> orders = new ArrayList<>();

    public Orders() {
    }

    public void addOrder( Order order ) {
        orders.add(order);
    }

    public int getOrderSize() {
        return orders.size();
    }

    public int getAmount() {
        int amount = 0;
        for( Order order : orders) {
            Menu current = MenuRepository.getMenu(order.number);
            amount += current.getPrice(order.quantity);
        }
        return amount;
    }

    public boolean orderNothing() {
        return orders == null;
    }
}
