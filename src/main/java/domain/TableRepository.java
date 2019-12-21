package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        for (Integer tableNumber : TableConfig.TABLES_NUMBERS) {
            tables.add(new Table(tableNumber));
        }
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }
}
