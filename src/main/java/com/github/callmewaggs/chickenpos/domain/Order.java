package com.github.callmewaggs.chickenpos.domain;

public class Order {
  private Menu menu;
  private int amount;

  public Order(Menu menu, int amount) {
    this.menu = menu;
    this.amount = amount;
  }

  public int getAmountIfMenuIsChicken() {
    if(menu.getCategory().equals(Category.CHICKEN)) {
      return amount;
    }
    return 0;
  }

  public int getTotalPriceOfOrder() {
    return menu.getPrice() * amount;
  }

  @Override
  public String toString() {
    return menu.getName() + " " + amount + " " + menu.getPrice();
  }
}
