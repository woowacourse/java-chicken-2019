package com.github.callmewaggs;

import com.github.callmewaggs.chickenpos.ChickenPOS;
import com.github.callmewaggs.chickenpos.discountpolicy.AmountDiscountPolicy;
import com.github.callmewaggs.chickenpos.discountpolicy.CashDiscountPolicy;
import com.github.callmewaggs.chickenpos.domain.order.OrderHistory;
import com.github.callmewaggs.chickenpos.service.OrderingService;
import com.github.callmewaggs.chickenpos.service.PaymentService;

public class Application {
  public static void main(String[] args) {
    OrderHistory orderHistory = new OrderHistory();
    OrderingService orderingService = new OrderingService(orderHistory);
    PaymentService paymentService =
        new PaymentService(orderHistory, new CashDiscountPolicy(), new AmountDiscountPolicy());
    ChickenPOS chickenPOS = new ChickenPOS(orderingService, paymentService);
    chickenPOS.start();
  }
}
