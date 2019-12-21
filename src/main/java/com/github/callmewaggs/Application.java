package com.github.callmewaggs;

import com.github.callmewaggs.chickenpos.ChickenPOS;
import com.github.callmewaggs.chickenpos.discountpolicy.AmountDefaultDiscountPolicy;
import com.github.callmewaggs.chickenpos.discountpolicy.CashDefaultDiscountPolicy;
import com.github.callmewaggs.chickenpos.domain.OrderHistory;
import com.github.callmewaggs.chickenpos.service.OrderingService;
import com.github.callmewaggs.chickenpos.service.PaymentService;

public class Application {
  public static void main(String[] args) {
    OrderHistory orderHistory = new OrderHistory();
    OrderingService orderingService = new OrderingService(orderHistory);
    PaymentService paymentService = new PaymentService(orderHistory, new CashDefaultDiscountPolicy(), new AmountDefaultDiscountPolicy());
    ChickenPOS chickenPOS = new ChickenPOS(orderingService, paymentService);
    chickenPOS.start();
  }
}
