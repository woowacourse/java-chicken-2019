package com.github.callmewaggs.chickenpos.discount;

import com.github.callmewaggs.chickenpos.domain.Order;
import java.util.List;

public abstract class Discount {
  List<Order> orders;

  public double totalPrice() {
    return orders.stream().mapToInt(Order::getTotalPriceOfOrder).sum();
  }

  public abstract boolean isDiscountable(List<Order> orders, int method);

  public abstract double afterDiscount();
}
