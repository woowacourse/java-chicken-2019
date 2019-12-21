/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * Table.java
 * Table에 대한 정보를 담고있는 객체
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        21 Dec 2019
 *
 */

package domain;

import java.util.ArrayList;
import java.util.List;

import util.PosRule;

public class Table {
    private final int number;
    private List<Order> orders;
    private int countOfChicken;

    public Table(final int number) {
        this.number = number;
        orders = new ArrayList<>();
        countOfChicken = PosRule.ZERO;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void order(Order order) {
        if (order.getMenu().getCategory().equals(PosRule.CHICKEN)) {
            countOfChicken++;
        }
        orders.add(order);
    }

    public boolean hasOrder() {
        return (orders.size() > PosRule.ZERO);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getCountOfChicken() {
        return countOfChicken;
    }

    public void completePayment() {
        orders.clear();
    }
}
