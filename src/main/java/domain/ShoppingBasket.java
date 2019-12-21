package domain;

import java.util.LinkedList;
import java.util.Queue;

public class ShoppingBasket {
    private static final int ONE_CHICKEN_DISCOUNT = 10000;

    private Queue<Order> orderQueue;

    public ShoppingBasket() {
        orderQueue = new LinkedList<Order>();
    }

    public void offer(Order order) {
        orderQueue.offer(order);
    }

    /**
     * @return 치킨 10마리당 할인을 포함한 가격을 반환한다.
     */
    public int sum() {
        int sum = 0;
        int chicken = 0;
        int discount = 0;
        for (Order order: orderQueue) {
            if (order.isChicken()) {
                chicken += order.amount();
            }
            sum += order.price();
        }
        discount = chicken / 10;
        return sum - discount * ONE_CHICKEN_DISCOUNT;
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
