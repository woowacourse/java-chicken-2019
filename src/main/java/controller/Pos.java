package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Pos {

  private final int ORDER = 1;
  private final int PAY = 2;
  private final int END = 3;


  public void start() {
    int process = getProcess();

    final List<Table> tables = TableRepository.tables();
    OutputView.printTables(tables);

    final int tableNumber = InputView.inputTableNumber();

    final List<Menu> menus = MenuRepository.menus();
    OutputView.printMenus(menus);
  }

  private int getProcess(){
    return validateProcessNumber(InputView.inputProcessNumber());
  }

  private int isInProcess(int processNumber) throws Exception {
    if(processNumber != ORDER && processNumber != PAY && processNumber != END){
      throw new Exception("1, 2, 3 중 하나만 입력해주세요.");
    }
    return processNumber;
  }

  private int validateProcessNumber(int processNumber){
    try{
      return isInProcess(processNumber);
    }catch (Exception e){
      System.out.println(e.getMessage());
      return getProcess();
    }
  }

}
