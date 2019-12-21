package com.github.callmewaggs.chickenpos;

import com.github.callmewaggs.chickenpos.domain.Menu;
import com.github.callmewaggs.chickenpos.domain.MenuRepository;
import com.github.callmewaggs.chickenpos.domain.MenuService;
import com.github.callmewaggs.chickenpos.domain.TableService;
import com.github.callmewaggs.chickenpos.view.OutputView;
import java.util.List;

public class ChickenPOS {

  private TableService tableService;
  private MenuService menuService;

  public ChickenPOS(TableService tableService, MenuService menuService) {
    this.tableService = tableService;
    this.menuService = menuService;
  }

  public void start() {
    tableService.showTables();
    final int tableNumber = tableService.inputTableNumber();

    menuService.showMenus();
    final int menuNumber = menuService.inputMenuNumber();
  }
}
