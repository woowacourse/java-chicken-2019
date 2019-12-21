package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private final List<Order> tableOrders;
    private final double CASH_DISCOUNT_RATE = 0.95;
    private int totalPrice;

    public Calculator(int paymentSelect, List<Order> tableOrders) {
        this.tableOrders = tableOrders;

        this.noDisCountTotalPrice();

        if (paymentSelect == 2) {
            this.cashDiscount();
        }

        this.quantityDiscount();
    }

    private void noDisCountTotalPrice() {
        List<Integer> orderPrices = tableOrders.stream().map(tableOrder -> tableOrder.totalPrice()).collect(Collectors.toList());
        this.totalPrice = orderPrices.stream().mapToInt(Integer::intValue).sum();
    }

    private void cashDiscount() {
        totalPrice *= CASH_DISCOUNT_RATE;
    }

    private void quantityDiscount() {
        final int QUANTITY_DISCOUNT_VALUE = 10;
        final int QUANTITY_DISCOUNT_PAY = 10000;

        List<Integer> orderQuantity = tableOrders.stream().map(tableOrder -> tableOrder.getQuantity()).collect(Collectors.toList());
        int totalQuantity = orderQuantity.stream().mapToInt(Integer::intValue).sum();

        if (totalQuantity >= QUANTITY_DISCOUNT_VALUE) {
            totalPrice -= QUANTITY_DISCOUNT_PAY * (totalQuantity / QUANTITY_DISCOUNT_VALUE);
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
