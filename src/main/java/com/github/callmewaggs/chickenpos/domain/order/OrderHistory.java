package com.github.callmewaggs.chickenpos.domain.order;

import com.github.callmewaggs.chickenpos.service.MenuService;
import com.github.callmewaggs.chickenpos.service.TableService;
import com.github.callmewaggs.chickenpos.view.OutputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderHistory {
  private Map<Integer, List<Order>> ordersByTable;
  private MenuService menuService;
  private TableService tableService;

  public OrderHistory() {
    this.ordersByTable = new HashMap<>();
    this.menuService = new MenuService();
    this.tableService = new TableService();
  }

  public void addNewOrder(int tableNumber, int menuNumber, int menuAmount) {
    Order order;
    order = new Order(menuService.getMenu(menuNumber), menuAmount);
    if (!ordersByTable.containsKey(tableNumber)) {
      ordersByTable.put(tableNumber, new ArrayList<>());
      tableService.markTable(tableNumber);
    }
    ordersByTable.get(tableNumber).add(order);
  }

  public void showOrdersByTable(int tableNumber) {
    try {
      List<Order> orders = ordersByTable.get(tableNumber);
      OutputView.printOrders(orders);
    } catch (Exception e) {
      OutputView.printMessage(e.getMessage());
    }
  }

  public List<Order> getOrdersByTable(int tableNumber) {
    try {
      return ordersByTable.get(tableNumber);
    } catch (Exception e) {
      OutputView.printMessage(e.getMessage());
    }
    throw new IllegalArgumentException("테이블 번호가 잘못됐습니다.");
  }

  public double getTotalPriceByTable(int tableNumber) {
    List<Order> orders = ordersByTable.get(tableNumber);
    double price = 0;
    for (Order order : orders) {
      price += order.getTotalPriceOfOrder();
    }
    return price;
  }
}
