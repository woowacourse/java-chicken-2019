package com.github.callmewaggs.chickenpos.discountpolicy;

import com.github.callmewaggs.chickenpos.domain.Order;
import java.util.List;

public class CashDiscountPolicy extends DefaultDiscountPolicy {
  private static final double DISCOUNT_PERCENT = 0.05;
  private static final double ORIGINAL_PERCENT = 1;

  @Override
  public double afterDiscount(double totalPrice) {
    return totalPrice * (ORIGINAL_PERCENT - DISCOUNT_PERCENT);
  }

  @Override
  public boolean isDiscountable(List<Order> orders, int method) {
    return Method.CASH.equalTo(method);
  }
}
