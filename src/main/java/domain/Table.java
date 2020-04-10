package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Table {

    private final int number;
    private final Map<Menu, Integer> orderHistory = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public void registerMenu(Menu menu, int menuCount) {
        if (!orderHistory.containsKey(menu)) {
            orderHistory.put(menu, 0);
        }
        orderHistory.put(menu, orderHistory.get(menu) + menuCount);
    }

    public boolean hasOrdered() {
        return !orderHistory.isEmpty();
    }

    public Map<Menu, Integer> getOrderHistory() {
        return Collections.unmodifiableMap(orderHistory);
    }

    public int getPaymentAmount() {
        return orderHistory.keySet().stream()
            .mapToInt(Menu::getPrice)
            .sum();
    }

    public void pay(PaymentMethod paymentMethod) {
        this.orderHistory.clear();
    }

    public boolean isNumber(int number) {
        return this.number == number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
