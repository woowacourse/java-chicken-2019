package com.github.callmewaggs.chickenpos.service;

import com.github.callmewaggs.chickenpos.domain.OrderHistory;

public class OrderingService {
  OrderHistory orderHistory;
  private TableService tableService;
  private MenuService menuService;

  public OrderingService(OrderHistory orderHistory) {
    this.orderHistory = orderHistory;
  }

  public void startOrdering() {
    tableService.showTables();
    int tableNumber = tableService.inputTableNumber();
    menuService.showMenus();
    int menuNumber = menuService.inputMenuNumber();
    int menuAmount = menuService.inputMenuAmount();

    orderHistory.addNewOrder(tableNumber, menuNumber, menuAmount);
  }
}
