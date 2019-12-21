package com.github.callmewaggs.chickenpos.domain;

import com.github.callmewaggs.chickenpos.service.MenuService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderHistory {
  Map<Integer, List<Order>> orders;
  MenuService menuService;

  public OrderHistory() {
    this.orders = new HashMap<>();
    this.menuService = new MenuService();
  }

  public void addNewOrder(int tableNumber, int menuNumber, int menuAmount) {
    Order order = new Order(menuService.getMenu(menuNumber), menuAmount);
    if (orders.containsKey(tableNumber)) {
      orders.put(tableNumber, new ArrayList<>());
    }
    orders.get(tableNumber).add(order);
  }
}
