package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Orders {
    private static final int MAXIMUM_ORDERS_SIZE = 99;
    private final List<Order> orders;

    private Orders(List<Order> orders) {
        this.orders = orders;
    }

    public static Orders emptyOrders() {
        return new Orders(new ArrayList<>());
    }

    private void validateAmount(Order order) {
        int inputOrdersSize = order.getAmount();
        int presentSize = this.orders.stream()
                .map(Order::getAmount)
                .reduce(0, Integer::sum);
        int totalSize = presentSize + inputOrdersSize;

        if (totalSize > MAXIMUM_ORDERS_SIZE) {
            throw new IllegalArgumentException(String.format("한 테이블에 99개 이상의 주문을 할 수 없습니다.\n현재 주문량 : %d\n직전 주문량 : %d\n주문 가능 수량 : %d", presentSize, inputOrdersSize, MAXIMUM_ORDERS_SIZE - presentSize));
        }
    }

    public int chickenSize() {
        return (int) orders.stream()
                .filter(Order::isChicken)
                .count();
    }

    public int getPrice() {
        return orders.stream()
                .map(Order::getPrice)
                .reduce(0, Integer::sum);
    }

    public void addMenu(Order order) {
        validateAmount(order);
        this.orders.add(order);
    }

    public void clear() {
        this.orders.clear();
    }

    public boolean isEmpty() {
        return this.orders.isEmpty();
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(this.orders);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders1 = (Orders) o;
        return Objects.equals(orders, orders1.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders);
    }
}
