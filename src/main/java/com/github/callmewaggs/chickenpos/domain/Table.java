package com.github.callmewaggs.chickenpos.domain;

public class Table {
  private final int number;
  private boolean available;

  public Table(final int number, boolean available) {
    this.number = number;
    this.available = available;
  }

  public boolean isNumber(int number) {
    return this.number == number;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean state) {
    this.available = state;
  }

  @Override
  public String toString() {
    return Integer.toString(number);
  }
}
