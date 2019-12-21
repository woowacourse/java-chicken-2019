package com.github.callmewaggs.chickenpos.service;

import com.github.callmewaggs.chickenpos.domain.order.OrderHistory;
import com.github.callmewaggs.chickenpos.view.OutputView;

public class OrderingService {
  private OrderHistory orderHistory;
  private TableService tableService;
  private MenuService menuService;

  public OrderingService(OrderHistory orderHistory) {
    this.orderHistory = orderHistory;
    tableService = new TableService();
    menuService = new MenuService();
  }

  public void startOrdering() {
    while (true) {
      tableService.showTables();
      int tableNumber = tableService.inputTableNumber();
      menuService.showMenus();
      int menuNumber = menuService.inputMenuNumber();
      int menuAmount = menuService.inputMenuAmount();

      try {
        orderHistory.addNewOrder(tableNumber, menuNumber, menuAmount);
        break;
      } catch (Exception e) {
        OutputView.printMessage(e.getMessage());
      }
    }
  }
}
