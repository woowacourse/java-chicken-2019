/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package controller;

import domain.Order;
import domain.Table;

import java.util.ArrayList;
import java.util.List;


public class PaymentController {
    public List<Table> orderedTables = new ArrayList<>();


    public void paymentController(List<Table> inputOrderedTables) {
        orderedTables = inputOrderedTables;
        for (Table orderedTable : orderedTables) {
            List<Order> orders = orderedTable.getOrders();
            for(Order order : orders) {
                System.out.println(order.getQuantity());
            }
        }

    }
}
