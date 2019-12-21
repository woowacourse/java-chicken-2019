package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Pos {

  public void start() {
    final List<Table> tables = TableRepository.tables();
    OutputView.printTables(tables);

    final int tableNumber = InputView.inputTableNumber();

    final List<Menu> menus = MenuRepository.menus();
    OutputView.printMenus(menus);
  }
}
