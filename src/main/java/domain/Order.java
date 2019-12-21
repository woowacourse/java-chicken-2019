package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Order {

  private final List<Table> tables;
  private final List<Menu> menus;

  private final HashMap<Integer, Integer> tableNumbers = new HashMap<>();
  private final HashMap<Integer, Integer> menuNumbers = new HashMap<>();

  public Order(List<Table> tables, List<Menu> menus) {
    this.tables = tables;
    this.menus = menus;

    getTableNumberList();
    getMenuNumberList();
  }

  private void getMenuNumberList() {
    for(int i = 0; i < this.menus.size(); i++){
      menuNumbers.put(this.menus.get(i).getNumber(),i);
    }
  }

  private void getTableNumberList() {
    for(int i = 0; i < this.tables.size(); i++){
      tableNumbers.put(this.tables.get(i).getNumber(),i);
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
    if (menuNumbers.containsKey(menuNumber)) {
      return menuNumber;
    }
    throw new Exception("메뉴가 존재하지 않습니다.");
  }

  private int isInTableList(int tableNumber) throws Exception {
    if (tableNumbers.containsKey(tableNumber)) {
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
