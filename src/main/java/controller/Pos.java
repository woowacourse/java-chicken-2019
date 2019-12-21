package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.Pay;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Pos {

  private final int ORDER = 1;
  private final int PAY = 2;
  private final int END = 3;

  private final List<Table> tables;
  private final List<Menu> menus;
  private final Order order = new Order();
  private final Pay pay = new Pay();

  public Pos(List<Table> tables, List<Menu> menus) {
    this.tables = tables;
    this.menus = menus;
  }

  public void start() {
    int process;

    do {
      process = getProcess();
      runProcess(process);
    } while (process != END);

    final List<Table> tables = TableRepository.tables();
    OutputView.printTables(tables);

    final int tableNumber = InputView.inputTableNumber();

    final List<Menu> menus = MenuRepository.menus();
    OutputView.printMenus(menus);
  }

  private void runProcess(int process){
    if(process == ORDER){
      return order.start();
    }

    if(process == PAY){
      return pay.start();
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
