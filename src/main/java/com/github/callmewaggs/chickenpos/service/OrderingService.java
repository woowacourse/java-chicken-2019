package com.github.callmewaggs.chickenpos.service;

import com.github.callmewaggs.chickenpos.domain.OrderHistory;

public class OrderingService {
  OrderHistory orderHistory;


  public OrderingService(OrderHistory orderHistory) {
    this.orderHistory = orderHistory;
  }

  public void startOrdering() {
    orderHistory.addNewOrder();
  }
}
