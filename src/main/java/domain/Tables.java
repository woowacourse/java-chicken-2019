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

    public boolean isTableExist(int number) {
        return tables.stream().anyMatch(x -> x.isTableNumberSame(number));
    }
}
