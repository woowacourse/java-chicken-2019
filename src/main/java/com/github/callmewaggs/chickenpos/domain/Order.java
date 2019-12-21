package com.github.callmewaggs.chickenpos.domain;

import com.github.callmewaggs.chickenpos.view.OutputView;

public class Order {
  private Menu menu;
  private int amount;

  public Order(Menu menu, int amount) {
    this.menu = menu;
    this.amount = amount;
  }

  @Override
  public String toString() {
    return menu.getName() + " " + amount + menu.getPrice();
  }
}
