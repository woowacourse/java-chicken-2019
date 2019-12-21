package domain;

import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Order {

  private final List<Table> tables;
  private final List<Menu> menus;

  private final List<Integer> tableNumbers = new ArrayList<>();
  private final List<Integer> menuNumbers = new ArrayList<>();

  public Order(List<Table> tables, List<Menu> menus) {
    this.tables = tables;
    this.menus = menus;

    getTableNumberList();
    getMenuNumberList();
  }

  private void getMenuNumberList() {
    for (Menu menu : menus) {
      menuNumbers.add(menu.getNumber());
    }
  }

  private void getTableNumberList() {
    for (Table table : tables) {
      tableNumbers.add(table.getNumber());
    }
  }

  public void start() {
    final int tableNumber = getTableNumber();
    final int menuNumber = getMenuNumber();

  }

  private int getMenuNumber() {
    OutputView.printMenus(menus);
    return validateMenuNumber(InputView.inputMenuNumber());
  }

  private int validateMenuNumber(int menuNumber) {
    try {
      return isInMenuList(menuNumber);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return getMenuNumber();
    }
  }


  private int getTableNumber() {
    OutputView.printTables(tables);
    return validateTableNumber(InputView.inputTableNumber());
  }

  private int isInMenuList(int menuNumber) throws Exception {
    if (menuNumbers.contains(menuNumber)) {
      return menuNumber;
    }
    throw new Exception("메뉴가 존재하지 않습니다.");
  }

  private int isInTableList(int tableNumber) throws Exception {
    if (tableNumbers.contains(tableNumber)) {
      return tableNumber;
    }
    throw new Exception("테이블이 존재하지 않습니다.");
  }

  private int validateTableNumber(int tableNumber) {
    try {
      return isInTableList(tableNumber);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return getTableNumber();
    }
  }
}
