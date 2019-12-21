package domain;

import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private List<Table> tables;
    private List<Menu> menus;
    private Map<Integer, List<Menu>> orderedList;

    public Order(){
        tables = TableRepository.tables();
        menus = MenuRepository.menus();
        orderedList = new HashMap<>();
    }

    public void getOrder() {
        OutputView.printTables(tables);
        
    }
}
