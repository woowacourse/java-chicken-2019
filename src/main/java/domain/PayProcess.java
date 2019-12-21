package domain;

import java.awt.image.ShortLookupTable;
import java.util.HashMap;
import java.util.List;
import javafx.scene.control.Tab;
import view.InputView;
import view.OutputView;

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

  private Table getTable(int tableNumber) {
    return this.tables.get(this.tableNumbers.get(tableNumber));
  }

  private Menu getMenu(int menuNumber) {
    return this.menus.get(this.menuNumbers.get(menuNumber));
  }

  public void start() {
    if(!hasOrdered()){
      System.out.println("주문이 존재하지 않습니다.");
      return;
    }

    int tableNumber = getTableNumber();
  }

  private int getTableNumber() {
    OutputView.printTables(tables);
    return validateTableNumber(InputView.inputTableNumber());
  }

  private int validateTableNumber(int tableNumber){
    try{
     return hasOrdered(tableNumber);
    }catch (Exception e){
      System.out.println(e.getMessage());
      return getTableNumber();
    }
  }
  private int hasOrdered(int tableNumber) throws Exception {
    Table table = getTable(tableNumber);
    if(!table.hasOrdered()){
      throw new Exception("주문이 존재하지 않습니다.");
    }
    return tableNumber;
  }

  private boolean hasOrdered(){
    for(int i = 0; i < tables.size(); i++){
      if(tables.get(i).hasOrdered()){
        return true;
      }
    }
    return false;
  }
}
