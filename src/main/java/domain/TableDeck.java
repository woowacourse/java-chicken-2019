package domain;

import java.util.ArrayList;
import java.util.List;

public class TableDeck {
    private List<Table> tables;

    public TableDeck() {
        this.tables = new ArrayList<>(TableRepository.tables());
    }

    public void add(Table table) {
        tables.add(table);
    }

    public void pop(int tableNumber) {
        tables.removeIf(table -> table.isNumber(tableNumber));
    }

    public boolean isTaken(Table table) {
        return !tables.contains(table);
    }

    public List<Table> getTables() {
        return tables;
    }
}
