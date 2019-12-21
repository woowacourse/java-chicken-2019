package com.github.callmewaggs.chickenpos.service;

import com.github.callmewaggs.chickenpos.discount.Discount;
import com.github.callmewaggs.chickenpos.domain.Order;
import com.github.callmewaggs.chickenpos.domain.OrderHistory;
import java.util.Arrays;
import java.util.List;

public class PaymentService {
  private OrderHistory orderHistory;
  private TableService tableService;
  private List<Discount> discounts;

  public PaymentService(OrderHistory orderHistory, Discount ... discounts) {
    this.orderHistory = orderHistory;
    this.tableService = new TableService();
    this.discounts = Arrays.asList(discounts);
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
