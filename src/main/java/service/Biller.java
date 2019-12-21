package service;

import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Biller extends Service {

    public Biller(int number, String name) {
        super(number, name);
    }

    public void run(List<Table> tables) {
        Table table;

        OutputView.printTables(tables);
        table = getTable(tables, InputView.inputTableNumber());
        OutputView.printOrderedMenu(table.getOrderedMenu());
    }

    private Table getTable(List<Table> tables, int tableNumber) {
        for (Table table : tables) {
            if (table.equals(tableNumber)) {
                return table;
            }
        }
        return null;
    }

}
