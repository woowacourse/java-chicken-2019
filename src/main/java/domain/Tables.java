package domain;

import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static view.OutputView.*;

public class Tables {
    public static final int TABLEE_INDEX = 0;
    public static final int CASH_INPUT = 2;
    public static final double CASH_DISCOUNT = 0.95;
    private List<Table> tables;

    public Tables(List<Table> tables) {
        this.tables = tables;
    }

    public boolean hasTableNumber(int tableNumber) {
        for (Table table : tables) {
            if (table.isEqualNumber(tableNumber)) {
                return true;
            }
        }
        OutputView.printInputTableNumberException();
        return false;
    }

    public int size() {
        return tables.size();
    }

    public void orderPrintTableNumbers() {
        for (final Table table : tables) {
            printTableNumber(table);
        }
    }

    public void orderPrintBottomState() {
        for (final Table table : tables) {
            if (table.hasMenu()) {
                printOrderedFormat();
            }
            if (!table.hasMenu()) {
                printBottomLine();
            }
        }
    }

    public void addMenu(int tableNumber, Menu menu, int menuQuantity) {
        for (int i = 0; i < menuQuantity; i++) {
            getTable(tableNumber).addMenu(menu);
        }
    }

    public Table getTable(int tableNumber) {
        List<Table> table;
        table = tables.stream().filter(p -> p.isEqualNumber(tableNumber)).collect(Collectors.toList());
        return table.get(TABLEE_INDEX);
    }

    public String getTableMenu(int tableNumber) {
        return getTable(tableNumber).getMenus();
    }

    public void payTableMenu(int tableNumber, int paymentMethod) {
        Table payTable = getTable(tableNumber);
        int tablePrice = payTable.getPrice();
        if (paymentMethod == CASH_INPUT) {
            tablePrice = (int) (tablePrice * CASH_DISCOUNT);
        }
        OutputView.printFinalPrice(tablePrice);
        payTable.clear();
    }
}
