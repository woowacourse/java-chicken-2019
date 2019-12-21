package service;

import domain.Menu;
import domain.OrderedMenu;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Biller extends Service {
    private final static double DISCOUNT_IF_CASH = 0.95;
    private final static int OPTION_NUMBER_OF_CAHS = 2;

    public Biller(int number, String name) {
        super(number, name);
    }

    public void run(List<Table> tables) {
        Table table;

        OutputView.printTables(tables);
        table = getTable(tables, InputView.inputTableNumber());
        table.printOrderedMenu();
        OutputView.printStartCalculatingPrice(table);
        calculateTotalPrice(table,InputView.inputCardOrCash());
    }

    private Table getTable(List<Table> tables, int tableNumber) {
        for (Table table : tables) {
            if (table.equals(tableNumber)) {
                return table;
            }
        }
        return null;
    }

    private int calculateTotalPrice(Table table, int cardOrCash) {
        int totalPrice = table.getSumOfPrice();
        if(cardOrCash == OPTION_NUMBER_OF_CAHS){
            totalPrice = (int)(totalPrice * DISCOUNT_IF_CASH);
        }
        return totalPrice;
    }

}
