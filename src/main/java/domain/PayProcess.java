package domain;

import java.util.HashMap;
import java.util.List;

public class PayProcess {

  private final List<Table> tables;
  private final List<Menu> menus;

  private final HashMap<Integer, Integer> tableNumbers;
  private final HashMap<Integer, Integer> menuNumbers;

  public PayProcess(List<Table> tables, List<Menu> menus, HashMap<Integer, Integer> tableNumbers,
      HashMap<Integer, Integer> menuNumbers) {
    this.tables = tables;
    this.menus = menus;
    this.tableNumbers = tableNumbers;
    this.menuNumbers = menuNumbers;


  }

  public void start() {

  }
}
