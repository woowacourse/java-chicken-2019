/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * Payment.java
 * 결제에 대한 정보를 담고있는 객체
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        21 Dec 2019
 *
 */

package domain;

import java.util.List;

import util.PosRule;

public class Payment {
    private int paymentMethod;
    private Table table;
    private double totalPrice;

    private Payment() {
    }

    public Payment(Table table, int paymentMethod) {
        this.paymentMethod = paymentMethod;
        this.table = table;
        totalPrice = PosRule.ZERO;
    }

    public void pay() {
        List<Order> orders = table.getOrders();
        totalPrice = PosRule.ZERO;

        for (Order order : orders) {
            totalPrice += order.getMenu().getPrice() * order.getCount();
        }

        totalPrice -= (table.getCountOfChicken() / PosRule.TEN) * PosRule.TEN_THOUSAND;

        if (paymentMethod == PosRule.CASH) {
            totalPrice = totalPrice * PosRule.PAY_RATE;
        }
    }

    @Override
    public String toString() {
        return totalPrice + PosRule.MONEY_UNIT;
    }
}
