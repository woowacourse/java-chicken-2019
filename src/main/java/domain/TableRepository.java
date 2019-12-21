package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();
    private static final Table NOT_EXSIT_TABLE = null;

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static Boolean isMatchingTableExist(int tableNumber) {
        for (Table table : TableRepository.tables()) {
            if (table.isMatchingTable(tableNumber)) {
                return true;
            }
        }
        return false;
    }

    public static Table findTableByNumber(int tableNumber) {
        for (Table table : tables()) {
            if (table.isMatchingTable(tableNumber)) {
                return table;
            }
        }
        return NOT_EXSIT_TABLE;
    }
}
