package domain;

import java.util.ArrayList;
import java.util.List;

public class TableDeck {
    private List<Table> tables;

    public TableDeck() {
        this.tables = new ArrayList<>(TableRepository.tables());
    }

    public Table pop() {
        return tables.remove(0);
    }
}
