package domain;

import java.util.LinkedList;
import java.util.Queue;

public class ShoppingBasket {
    private Queue<Order> orderQueue;

    public ShoppingBasket() {
        orderQueue = new LinkedList<Order>();
    }

    public void offer(Order order) {
        orderQueue.offer(order);
    }

    public int sum() {
        int sum = 0;
        for (Order order: orderQueue) {
            sum += order.price();
        }

        return sum;
    }

    public void clear() {
        orderQueue.clear();
    }

    public boolean isEmpty() {
        return orderQueue.isEmpty();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("메뉴 수량 금액\n");
        for (Order order: orderQueue) {
            stringBuilder.append(order.toString())
                    .append('\n');
        }

        return stringBuilder.toString();
    }
}
