package com.github.callmewaggs.chickenpos.discount;

import com.github.callmewaggs.chickenpos.domain.Order;
import java.util.List;

public class CashDiscount extends Discount {
  private static final double DISCOUNT_PERCENT = 0.5;
  private static final double ORIGINAL_VALUE = 1;

  @Override
  public double afterDiscount() {
    return totalPrice() * ORIGINAL_VALUE - DISCOUNT_PERCENT;
  }

  @Override
  public boolean isDiscountable(List<Order> orders, int method) {
    return Method.CASH.equalTo(method);
  }
}
