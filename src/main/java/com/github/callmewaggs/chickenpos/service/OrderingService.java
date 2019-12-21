package com.github.callmewaggs.chickenpos.service;

public class OrderingService {
  private TableService tableService;
  private MenuService menuService;

  public OrderingService() {
    this.tableService = new TableService();
    this.menuService = new MenuService();
  }

  public void startOrdering() {
    tableService.showTables();
    menuService.showMenus();
    int menuNumber = menuService.inputMenuNumber();
    int menuAmount = menuService.inputMenuAmount();
  }
}
