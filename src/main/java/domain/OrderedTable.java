/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

public class OrderedTable {
    private Table orderedTable;
    private List<Order> orders = new ArrayList<>();

    public OrderedTable(int tableNumber, Order order) {
        orderedTable = new Table(tableNumber);
        putOrder(order);
    }

    public int getTableNumber() {
        return orderedTable.getNumber();
    }

    public void putOrder(Order inputOrder) {
        for (Order order : orders) {
            if (order.isSameOrder(inputOrder.getOrderNumber())){
                order.addQuantity(inputOrder.getQuantity());
                return;
            }
        }
        orders.add(inputOrder);
    }

    public List<Order> getOrders() {
        return orders;
    }

}
