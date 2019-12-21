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

public class Table {
    private final int number;
    private List<Order> orders;

    public Table(final int number) {
        this.number = number;
        orders = new ArrayList<>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void order(Order order) {
        orders.add(order);
    }

    public boolean hasOrder() {
        return (orders.size() > 0);
    }
}
