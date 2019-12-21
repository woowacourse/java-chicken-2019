/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package controller;

import domain.Order;
import domain.OrderedTable;

import java.util.ArrayList;
import java.util.List;

public class PaymentController {
    public List<OrderedTable> orderedTables = new ArrayList<>();


    public void paymentController(List<OrderedTable> inputOrderedTables) {
        orderedTables = inputOrderedTables;
        for (OrderedTable orderedTable : orderedTables) {
            List<Order> orders = orderedTable.getOrders();
            for(Order order : orders) {
                System.out.println(order.getQuantity());
            }
        }

    }
}
