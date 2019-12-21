package com.github.callmewaggs.chickenpos;

import com.github.callmewaggs.chickenpos.domain.Operation;
import com.github.callmewaggs.chickenpos.service.OrderingService;
import com.github.callmewaggs.chickenpos.service.PaymentService;
import com.github.callmewaggs.chickenpos.view.InputView;

public class ChickenPOS {
  private OrderingService orderingService;
  private PaymentService paymentService;

  public ChickenPOS(OrderingService orderingService, PaymentService paymentService) {
    this.orderingService = orderingService;
    this.paymentService = paymentService;
  }

  public void start() {
    while (true) {
      int operation = InputView.inputMainOperation();
      if (Operation.ORDERING.equals(operation)) {
        orderingService.startOrdering();
        continue;
      }
      if (Operation.PAYMENT.equals(operation)) {
        paymentService.startPayment();
        continue;
      }
      if (Operation.EXIT.equals(operation)) {
        break;
      }
      // TODO : 잘못된 입력값입니다.
    }
  }
}
