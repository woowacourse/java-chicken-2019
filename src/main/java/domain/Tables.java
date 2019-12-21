package domain;

import java.util.List;

public class Tables {
    private List<Table> tables;

    public Tables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Table> getTables() {
        return tables;
    }

    public Table findTable(int tableId) {
        return tables.stream()
                .filter(x -> x.isTableNumberSame(tableId))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isTableExist(int number) {
        return tables.stream().anyMatch(x -> x.isTableNumberSame(number));
    }
}
