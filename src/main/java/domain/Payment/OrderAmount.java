/*
 * @(#)OrderAmount.java     0.1 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

package domain.Payment;

public class OrderAmount {
    private static final int ZERO_ORDER_AMOUNT = 0;

    public static OrderAmount ZERO = new OrderAmount(ZERO_ORDER_AMOUNT);

    private final int orderAmount;

    public OrderAmount(int orderAmount) {
        isValid(orderAmount);

        this.orderAmount = ZERO_ORDER_AMOUNT;
    }

    private void isValid(int orderAmount) {
        if (orderAmount < ZERO_ORDER_AMOUNT) {
            throw new IllegalArgumentException("주문 금액이 0원보다 작을수 없습니다.");
        }
    }

    public OrderAmount add(int addOrderAmount) {
        return new OrderAmount(this.orderAmount + addOrderAmount);
    }

    public OrderAmount getOrderAmount()
}
