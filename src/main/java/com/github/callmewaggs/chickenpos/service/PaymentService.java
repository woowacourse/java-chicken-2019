package com.github.callmewaggs.chickenpos.service;

import com.github.callmewaggs.chickenpos.domain.Order;
import com.github.callmewaggs.chickenpos.domain.OrderHistory;
import java.util.List;

public class PaymentService {
  private OrderHistory orderHistory;
  private TableService tableService;

  public PaymentService(OrderHistory orderHistory) {
    this.orderHistory = orderHistory;
    this.tableService = new TableService();
  }

  public void startPayment() {
    tableService.showTables();
    int tableNumber = tableService.inputTableNumber();
    orderHistory.showOrdersByTable(tableNumber);
    paymentWithPolicy(tableNumber);
  }

  private void paymentWithPolicy(int tableNumber) {
    List<Order> orders = orderHistory.getOrdersByTable(tableNumber);

  }
}
