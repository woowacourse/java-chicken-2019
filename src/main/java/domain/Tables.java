package domain;

import view.OutputView;

import java.util.List;

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
}
