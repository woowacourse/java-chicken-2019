package controller;

import domain.Menu;
import domain.OrderProcess;
import domain.PayProcess;
import domain.Table;
import java.util.HashMap;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Pos {

  private final int ORDER = 1;
  private final int PAY = 2;
  private final int END = 3;

  private final List<Table> tables;
  private final List<Menu> menus;
  private final HashMap<Integer, Integer> tableNumbers = new HashMap<>();
  private final HashMap<Integer, Integer> menuNumbers = new HashMap<>();

  private final OrderProcess orderProcess;
  private final PayProcess payProcess;

  public Pos(List<Table> tables, List<Menu> menus) {
    this.tables = tables;
    this.menus = menus;

    getTableNumberList();
    getMenuNumberList();

    orderProcess = new OrderProcess(tables, menus, tableNumbers, menuNumbers);
    payProcess = new PayProcess(tables, tableNumbers);
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
    int process;

    do {
      process = getProcess();
      runProcess(process);

    } while (process != END);

  }

  private void runProcess(int process) {
    if (process == ORDER) {
      orderProcess.start();
      return;
    }

    try {
      if (process == PAY) {
        validatePay();
        payProcess.start();
        return;
      }
      endPos();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private void endPos() {
    try {
      validateEnd();
      OutputView.printEndPos();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      start();
      return;
    }
  }

  private boolean hasOrdered(Table table) {
    return table.hasOrdered();
  }

  private void validatePay(Table table) throws Exception {
    if (!hasOrdered(table)) {
      throw new Exception("주문이 존재하지 않습니다.");
    }
  }

  private void validatePay() throws Exception {
    for (Table table : tables) {
      validatePay(table);
    }
  }

  private void validateEnd() throws Exception {
    for (Table table : tables) {
      validateEnd(table);
    }
  }

  private void validateEnd(Table table) throws Exception {
    if (hasOrdered(table)) {
      throw new Exception("결제하지 않은 주문이 존재합니다.");
    }
  }


  private int getProcess() {
    return validateProcessNumber(InputView.inputProcessNumber());
  }

  private int isInProcess(int processNumber) throws Exception {
    if (processNumber != ORDER && processNumber != PAY && processNumber != END) {
      throw new Exception("1, 2, 3 중 하나만 입력해주세요.");
    }
    return processNumber;
  }

  private int validateProcessNumber(int processNumber) {
    try {
      return isInProcess(processNumber);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return getProcess();
    }
  }

}
