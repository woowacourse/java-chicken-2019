package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

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

    public static boolean isInTable(int number) {
        for (final Table table : tables) {
            if (table.isSameNumber(number)) {
                return true;
            }
        }
        return false;
    }

    public static Table getTable(int number) {
        for (final Table table : tables) {
            if (table.isSameNumber(number)) {
                return table;
            }
        }
        return null;
    }
}
