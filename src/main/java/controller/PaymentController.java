/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package controller;

import domain.Order;
import domain.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 결제를 컨트롤하는 클래스입니다. (2번 기능)
 * @since : 2019.12.23 월요일
 */
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
