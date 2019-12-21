package domain;

import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Order {

  private final List<Table> tables;
  private final List<Menu> menus;

  private final List<Integer> tableNumbers = new ArrayList<>();

  public Order(List<Table> tables, List<Menu> menus) {
    this.tables = tables;
    this.menus = menus;

    getTableNumberList();
  }

  private void getTableNumberList() {
    for (Table table : tables) {
      tableNumbers.add(table.getNumber());
    }
  }

  public void start() {
    final int tableNumber = getTableNumber();
  }

  private int getTableNumber() {
    OutputView.printTables(tables);
    return validateTableNumber(InputView.inputTableNumber());
  }

  private int isInList(int tableNumber) throws Exception {
    if (tableNumbers.contains(tableNumber)) {
      return tableNumber;
    }
    throw new Exception("테이블이 존재하지 않습니다.");
  }

  private int validateTableNumber(int tableNumber) {
    try {
      return isInList(tableNumber);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return getTableNumber();
    }
  }
}
