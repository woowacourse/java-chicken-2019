package com.github.callmewaggs.chickenpos.domain;

import com.github.callmewaggs.chickenpos.service.MenuService;
import com.github.callmewaggs.chickenpos.service.TableService;

public class OrderHistory {
  private TableService tableService;
  private MenuService menuService;

  public OrderHistory() {
    this.tableService = new TableService();
    this.menuService = new MenuService();
  }

  public void addNewOrder() {
    tableService.showTables();
    int tableNumber = tableService.inputTableNumber();
    menuService.showMenus();
    int menuNumber = menuService.inputMenuNumber();
    int menuAmount = menuService.inputMenuAmount();
  }
}
