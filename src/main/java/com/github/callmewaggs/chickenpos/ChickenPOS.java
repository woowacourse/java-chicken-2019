package com.github.callmewaggs.chickenpos;

import com.github.callmewaggs.chickenpos.service.OrderingService;
import com.github.callmewaggs.chickenpos.service.PaymentService;

public class ChickenPOS {
  private OrderingService orderingService;
  private PaymentService paymentService;

  public ChickenPOS(OrderingService orderingService, PaymentService paymentService) {
    this.orderingService = orderingService;
    this.paymentService = paymentService;
  }

  public void start() {
    while (true) {
      orderingService.startOrdering();

    }
  }
}
