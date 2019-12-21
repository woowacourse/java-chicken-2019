package domain;

import java.awt.image.ShortLookupTable;
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
    if(!hasOrdered()){
      System.out.println("주문이 존재하지 않습니다.");
      return;
    }
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
