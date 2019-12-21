package com.github.callmewaggs;

import com.github.callmewaggs.chickenpos.ChickenPOS;
import com.github.callmewaggs.chickenpos.service.OrderingService;
import com.github.callmewaggs.chickenpos.service.PaymentService;

public class Application {
  public static void main(String[] args) {
    OrderingService orderingService = new OrderingService();
    PaymentService paymentService = new PaymentService();
    ChickenPOS chickenPOS = new ChickenPOS(orderingService, paymentService);
    chickenPOS.start();
  }
}
