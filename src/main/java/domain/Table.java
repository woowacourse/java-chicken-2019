package domain;

import java.util.HashMap;

public class Table {

  private final int number;
  private HashMap<Menu, Integer> order = new HashMap<>();

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

  public void addOrder(Menu menu, int amount) {
    if (order.containsKey(menu)) {
      amount += order.get(menu);
      order.put(menu, amount);
      return;
    }
    order.put(menu, amount);
  }

  public int getMenuAmount(Menu menu) {
    if (order.containsKey(menu)) {
      return order.get(menu);
    }
    return 0;
  }

  public Boolean hasOrdered(){
    return !order.isEmpty();
  }


}
