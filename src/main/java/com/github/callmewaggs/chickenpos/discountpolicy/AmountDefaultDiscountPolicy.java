package com.github.callmewaggs.chickenpos.discountpolicy;

import com.github.callmewaggs.chickenpos.domain.Order;
import java.util.List;

public class AmountDefaultDiscountPolicy extends DefaultDiscountPolicy {
  private static final int MINIMUM_DISCOUNT_AMOUNT = 10;
  private static final int DISCOUNT_PRICE = 10000;

  public int countChickens() {
    int chickens = 0;
    for (Order order : orders) {
      chickens += order.getAmountIfMenuIsChicken();
    }
    return chickens;
  }

  @Override
  public double afterDiscount(double totalPrice) {
    int discountPrice = countChickens() % MINIMUM_DISCOUNT_AMOUNT * DISCOUNT_PRICE;
    return totalPrice - discountPrice;
  }

  @Override
  public boolean isDiscountable(List<Order> orders, int method) {
    super.orders = orders;
    if (countChickens() >= MINIMUM_DISCOUNT_AMOUNT) {
      return true;
    }
    return false;
  }
}
