package controller;

import domain.Menu;
import domain.Order;
import domain.OrderProcess;
import domain.PayProcess;
import domain.Table;
import java.util.ArrayList;
import java.util.List;
import view.InputView;

public class Pos {

  private final int ORDER = 1;
  private final int PAY = 2;
  private final int END = 3;

  private final List<Table> tables;
  private final List<Menu> menus;
  private final List<Order> orderList = new ArrayList<>();
  private final OrderProcess orderProcess;
  private final PayProcess payProcess = new PayProcess();

  public Pos(List<Table> tables, List<Menu> menus) {
    this.tables = tables;
    this.menus = menus;

    orderProcess = new OrderProcess(tables, menus, orderList);
  }

  public void start() {
    int process;

    do {
      process = getProcess();
      runProcess(process);

      for(int i = 0; i < orderList.size(); i++){
        System.out.println(orderList.get(i));
      }
    } while (process != END);

  }

  private void runProcess(int process) {
    if (process == ORDER) {
      orderProcess.start();
      return;
    }

    if (process == PAY) {
      payProcess.start();
      return;
    }

    return;
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
