package com.github.callmewaggs.chickenpos;

import com.github.callmewaggs.chickenpos.domain.Menu;
import com.github.callmewaggs.chickenpos.domain.MenuRepository;
import com.github.callmewaggs.chickenpos.domain.MenuService;
import com.github.callmewaggs.chickenpos.domain.Table;
import com.github.callmewaggs.chickenpos.domain.TableRepository;
import com.github.callmewaggs.chickenpos.domain.TableService;
import com.github.callmewaggs.chickenpos.view.InputView;
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
    final List<Table> tables = TableRepository.tables();
    OutputView.printTables(tables);

    final int tableNumber = InputView.inputTableNumber();

    final List<Menu> menus = MenuRepository.menus();
    OutputView.printMenus(menus);
  }
}
