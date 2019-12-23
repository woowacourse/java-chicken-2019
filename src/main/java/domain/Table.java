/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private final List<Order> orders = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return this.number;
    }

    public void setOrder(Order newOrder) {
        if (checkOrderExist(newOrder)) {
            addMoreOrder(newOrder);
            return;
        }
        orders.add(newOrder);
    }

    public boolean checkOrderExist(Order newOrder) {
        for (Order order : orders) {
            if (order.getOrderNumber() == newOrder.getOrderNumber()) {
                return true;
            }
        }
        return false;
    }

    public void addMoreOrder(Order newOrder) {
        for (Order order : orders) {
            if (order.getOrderNumber() == newOrder.getOrderNumber()) {
                order.addQuantity(newOrder.getQuantity());
            }
        }
    }

    public boolean isSameTable(int tableNumber) {
        return (number == tableNumber);
    }

    public List<Order> getOrders() {
        return orders;
    }


}
