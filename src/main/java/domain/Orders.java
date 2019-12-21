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

    public List<Order> orders() {
        return orders;
    }

    public void addOrder( Order order ) {
        orders.add(order);
    }

    public int getOrderSize() {
        int size = orders.stream()
                .filter(Order::isChicken)
                .mapToInt(order -> order.quantity)
                .sum();
        return size;
    }

    public int getAmount() {
        int amount = ORDER_NOTHING;
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

    public int getMenuSize( int menuNumber ) {
        int size = ORDER_NOTHING;
        for( Order order : orders) {
            if(order.isEqual(menuNumber)){
                size += order.getQuantity();
            }
        }
        return size;
    }

    @Override
    public String toString() {
        return orders.stream().map(Order::toString).collect(Collectors.joining(", "));
    }
}
