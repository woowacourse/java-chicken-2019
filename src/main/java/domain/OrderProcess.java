package domain;

import java.util.HashMap;
import java.util.List;
import view.InputView;
import view.OutputView;

public class OrderProcess {

  private final List<Table> tables;
  private final List<Menu> menus;
  private final List<Order> orderList;

  private final HashMap<Integer, Integer> tableNumbers = new HashMap<>();
  private final HashMap<Integer, Integer> menuNumbers = new HashMap<>();

  public OrderProcess(List<Table> tables, List<Menu> menus, List<Order> orderList) {
    this.tables = tables;
    this.menus = menus;
    this.orderList = orderList;

    getTableNumberList();
    getMenuNumberList();
  }

  private void getMenuNumberList() {
    for (int i = 0; i < this.menus.size(); i++) {
      menuNumbers.put(this.menus.get(i).getNumber(), i);
    }
  }

  private void getTableNumberList() {
    for (int i = 0; i < this.tables.size(); i++) {
      tableNumbers.put(this.tables.get(i).getNumber(), i);
    }
  }

  public void start() {
    final int tableNumber = getTableNumber();
    final int menuNumber = getMenuNumber();

    final int amount = getAmount(getTable(tableNumber), getMenu(menuNumber));

    addOrder(tableNumber, menuNumber, amount);
  }

  private void addOrder(int tableNumber, int menuNumber, int amount) {
    Order order = new Order(getTable(tableNumber), getMenu(menuNumber), amount);

    order.addToTable();
    addToOrderList(order);
  }

  private void addToOrderList(Order order) {
    orderList.add(order);
  }


  private Table getTable(int tableNumber) {
    return this.tables.get(this.tableNumbers.get(tableNumber));
  }

  private Menu getMenu(int menuNumber) {
    return this.menus.get(this.menuNumbers.get(menuNumber));
  }


  private int getAmount(Table table, Menu menu) {
    return validateAmount(table, menu, InputView.inputAmount());
  }

  private void isInRange(Table table, Menu menu, int amount) throws Exception {
    if (amount <= 0 || amount > 99) {
      throw new Exception("수량은 1이상 99 이하로 입력해주세요.");
    }
    //todo
    //테이블에 해당 메뉴 99개 이상인지 확인
  }

  private int validateAmount(Table table, Menu menu, int amount) {
    try {
      isInRange(table, menu, amount);
      return amount;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return getAmount(table, menu);
    }
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
