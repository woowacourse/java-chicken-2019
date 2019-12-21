package com.github.callmewaggs.chickenpos.service;

import com.github.callmewaggs.chickenpos.domain.OrderHistory;

public class PaymentService {
  OrderHistory orderHistory;

  public PaymentService(OrderHistory orderHistory) {
    this.orderHistory = orderHistory;
  }

  public void startPayment() {
  }
}
