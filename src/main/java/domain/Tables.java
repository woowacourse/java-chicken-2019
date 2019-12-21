package domain;

import view.OutputView;

import java.util.List;

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
}
