package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {

  private final int number;
  private List<Order> orderList = new ArrayList<>();

  public Table(final int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return Integer.toString(number);
  }

  public int getNumber() {
    return number;
  }

  public void addOrder(Order order) {
    orderList.add(order);
  }

}
