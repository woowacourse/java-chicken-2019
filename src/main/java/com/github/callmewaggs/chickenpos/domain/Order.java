package com.github.callmewaggs.chickenpos.domain;

public class Order {
  private Menu menu;
  private int amount;

  public Order(Menu menu, int amount) {
    this.menu = menu;
    this.amount = amount;
  }
}
