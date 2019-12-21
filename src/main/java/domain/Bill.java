package domain;

import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    final static int CASH = 2;
    final static int CASH_DISCOUNT_PERCENT = 5;
    final static int PER_EVERY_TEN = 10;
    final static int TEN_THOUSAND = 10_000;
    private List<Order> orders = new ArrayList<Order>();

    public Bill() {
    }

    public void updateBill(Order order) {
        orders.add(order);
    }

    public boolean hasOrders() {
        return orders.size() > 0;
    }

    public void showOrders() {
        for (Order order : orders) {
            OutputView.printOrder(order);
        }
    }

    public int calTotal(int paymentMethod) {
        int total = 0;
        for (Order order : orders) {
            total += order.price();
        }

        total -= rewardDiscount();

        if (paymentMethod == CASH) {
            total -= cashDiscount(total);
        }
        OutputView.printTotalPrice(total);
        return total;
    }

    public int rewardDiscount() {
        int numberOfChickens = getChickenNumbers();
        return (numberOfChickens / PER_EVERY_TEN) * TEN_THOUSAND;
    }

    public int getChickenNumbers() {
        int number = 0;
        for (Order order : orders) {
            number += order.countChicken();
        }
        return number;
    }

    public int cashDiscount(int total) {
        return (total * CASH_DISCOUNT_PERCENT) / 100;
    }
}
