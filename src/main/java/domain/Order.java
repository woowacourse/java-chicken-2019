package domain;

import view.InputView;
import view.Message;
import view.OutputView;

import java.util.ArrayList;
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
        int tableNumber = getTableNumber();
    }

    private int getTableNumber() {
        List<Integer> tableNumbers = TableRepository.getTableNumbers();

        OutputView.printTables(tables);
        return InputView.inputTableNumber(tableNumbers);
    }
}
