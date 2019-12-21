package com.github.callmewaggs;

import com.github.callmewaggs.chickenpos.ChickenPOS;
import com.github.callmewaggs.chickenpos.domain.MenuService;
import com.github.callmewaggs.chickenpos.domain.TableService;

public class Application {
  public static void main(String[] args) {
    TableService tableService = new TableService();
    MenuService menuService = new MenuService();
    ChickenPOS chickenPOS = new ChickenPOS(tableService, menuService);
    chickenPOS.start();
  }
}
