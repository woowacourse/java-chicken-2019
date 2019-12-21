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

  public void addOrder(Menu menu, int amount){
    if(order.containsKey(menu)){
      order.put(menu,amount);
      return ;
    }
    amount += order.get(menu);
    order.put(menu, amount);
  }


}
