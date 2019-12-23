/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 테이블에 관한 클래스입니다. 주문이 되면 안에 필드로 들어갑니다.
 * @since : 2019.12.23 월요일
 */
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
