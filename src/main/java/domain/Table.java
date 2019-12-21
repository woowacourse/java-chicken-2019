package domain;

import java.util.HashMap;

public class Table {

  private final String CHICKEN = "CHICKEN";
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

  public Boolean hasOrdered() {
    return !order.isEmpty();
  }

  public String getOrderResult() {
    String result = "";
    for (Menu menu : order.keySet()) {
      result += menu.getName() + " " + order.get(menu) + " " + menu.getPrice() + "\n";
    }
    return result;
  }

  public int getChickenAmount(){
    int amount = 0;
    for(Menu menu : order.keySet()){
      if(menu.getCategoryName().equals(CHICKEN)){
        amount += order.get(menu);
      }
    }
    return amount;
  }

  public int getAllPrice(){
    int price = 0;
    for(Menu menu : order.keySet()){
      price += (menu.getPrice()*order.get(menu));
    }
    return price;
  }

  public void pay(){
    for(Menu menu : order.keySet()){
      order.remove(menu);
    }
  }

}
