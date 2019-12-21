package com.github.callmewaggs.chickenpos.discountpolicy;

import com.github.callmewaggs.chickenpos.domain.Order;
import java.util.List;

public abstract class DefaultDiscountPolicy {
  List<Order> orders;

  public abstract boolean isDiscountable(List<Order> orders, int method);

  public abstract double afterDiscount(double totalPrice);
}
