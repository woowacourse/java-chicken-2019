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

    public static boolean isInTable(final int number) {
        for (final Table table : tables) {
            if (table.isSameNumber(number)) {
                return true;
            }
        }
        throw new IllegalArgumentException("입력된 값이 변경되었습니다.");
    }

    public static Table getTable(final int number) {
        for (final Table table : tables) {
            if (table.isSameNumber(number)) {
                return table;
            }
        }
        throw new IllegalArgumentException("입력된 값이 변경되었습니다.");
    }
}
