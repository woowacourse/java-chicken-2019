package domain;

import java.util.HashMap;
import java.util.List;
import view.InputView;
import view.OutputView;

public class PayProcess {

  private final int CARD = 1;
  private final int CASH = 2;
  private final int TEN = 10;
  private final int TEN_THOUSAND = 10000;
  private final int HUNDRED = 100;
  private final int NINETY_FIVE = 95;

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

  private Table getTable(int tableNumber) {
    return this.tables.get(this.tableNumbers.get(tableNumber));
  }

  private Menu getMenu(int menuNumber) {
    return this.menus.get(this.menuNumbers.get(menuNumber));
  }

  public void start() {
    if (!hasOrdered()) {
      System.out.println("주문이 존재하지 않습니다.");
      return;
    }

    int tableNumber = getTableNumber();
    pay(tableNumber);
  }

  private void pay(int tableNumber) {
    OutputView.printOrderResult(getTable(tableNumber));

    System.out.println("## " + getTable(tableNumber).getNumber() + "번 테이블의 결제를 진행힙니다.");
    int paymentMethod = getPaymentMethod();

    int price = calculatePrice(getTable(tableNumber), paymentMethod);

  }

  private int addPrice(Table table) {
    return table.getAllPrice();
  }

  private int calculateChickenDiscount(Table table) {
    int chickenAmount = table.getChickenAmount();
    return (TEN_THOUSAND * chickenAmount / TEN);
  }

  private int calculateCashDiscount(int price) {
    return price * NINETY_FIVE / HUNDRED;
  }

  private int calculatePrice(Table table, int paymentMethod) {
    int price = addPrice(table);
    price -= calculateChickenDiscount(table);
    if (paymentMethod == CASH) {
      price = calculateCashDiscount(price);
    }
    return price;
  }

  private int getPaymentMethod() {
    return validatePaymentMethod(InputView.inputPaymentMethod());
  }

  private int isInMethod(int method) throws Exception {
    if (method != CARD && method != CASH) {
      throw new Exception("1과 2만 입력할수 있습니다.");
    }
    return method;
  }

  private int validatePaymentMethod(int paymentMethod) {
    try {
      return isInMethod(paymentMethod);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return getPaymentMethod();
    }
  }

  private int getTableNumber() {
    OutputView.printTables(tables);
    return validateTableNumber(InputView.inputTableNumber());
  }

  private int validateTableNumber(int tableNumber) {
    try {
      return hasOrdered(tableNumber);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return getTableNumber();
    }
  }

  private int hasOrdered(int tableNumber) throws Exception {
    Table table = getTable(tableNumber);
    if (!table.hasOrdered()) {
      throw new Exception("주문이 존재하지 않습니다.");
    }
    return tableNumber;
  }

  private boolean hasOrdered() {
    for (int i = 0; i < tables.size(); i++) {
      if (tables.get(i).hasOrdered()) {
        return true;
      }
    }
    return false;
  }
}
