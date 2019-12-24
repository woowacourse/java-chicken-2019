package domain;

import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static view.OutputView.*;

public class Tables {
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

    private Table getTable(int tableNumber) {
        List<Table> table;
        table = tables.stream().filter(p -> p.isEqualNumber(tableNumber)).collect(Collectors.toList());
        return table.get(0);
    }

    public String getTableMenu(int tableNumber) {
        return getTable(tableNumber).getMenus();
    }

    public void payTableMenu(int tableNumber, int paymentMethod) {
        int tablePrice = getTable((tableNumber)).getPrice();
        if (paymentMethod == 2) {
            tablePrice = (int) (tablePrice * 0.95);
        }
        OutputView.printFinalPrice(tablePrice);
    }
}
