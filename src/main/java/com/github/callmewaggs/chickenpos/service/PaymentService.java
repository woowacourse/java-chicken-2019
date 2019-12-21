package com.github.callmewaggs.chickenpos.service;

import com.github.callmewaggs.chickenpos.discountpolicy.DefaultDiscountPolicy;
import com.github.callmewaggs.chickenpos.domain.Order;
import com.github.callmewaggs.chickenpos.domain.OrderHistory;
import com.github.callmewaggs.chickenpos.view.InputView;
import java.util.Arrays;
import java.util.List;

public class PaymentService {
  private OrderHistory orderHistory;
  private TableService tableService;
  private List<DefaultDiscountPolicy> defaultDiscountPolicies;

  public PaymentService(OrderHistory orderHistory, DefaultDiscountPolicy... defaultDiscountPolicies) {
    this.orderHistory = orderHistory;
    this.tableService = new TableService();
    this.defaultDiscountPolicies = Arrays.asList(defaultDiscountPolicies);
  }

  public void startPayment() {
    tableService.showTables();
    int tableNumber = tableService.inputTableNumber();
    orderHistory.showOrdersByTable(tableNumber);
    paymentWithPolicy(tableNumber);
  }

  private void paymentWithPolicy(int tableNumber) {
    double totalPrice = orderHistory.getTotalPriceByTable(tableNumber);
    int paymentMethod = InputView.inputPaymentMethod(tableNumber);
    List<Order> orders = orderHistory.getOrdersByTable(tableNumber);

    for (DefaultDiscountPolicy defaultDiscountPolicy : defaultDiscountPolicies) {
      if (defaultDiscountPolicy.isDiscountable(orders, paymentMethod)) {
        totalPrice = defaultDiscountPolicy.afterDiscount(totalPrice);
      }
    }
  }
}
