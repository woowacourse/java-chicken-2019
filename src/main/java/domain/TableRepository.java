package domain;

import java.util.*;

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

    public static List<Integer> tableNumbers() {
        List<Integer> tablesNumber = new ArrayList<Integer>();
        for (Table table : tables) {
            tablesNumber.add(Integer.parseInt(table.toString()));
        }
        return tablesNumber;
    }

    public static Table selectTable(int tableNumber) {
        Set<Table> selectTable = new HashSet<Table>();
        for (Table table : tables) {
            selectTable.add(compareTable(table, tableNumber));
        }
        selectTable.remove(null);
        return selectTable.iterator().next();
    }

    public static Table compareTable(Table table, int tableNumber) {
        if (Integer.parseInt(table.toString()) == tableNumber) {
            return table;
        }
        return null;
    }
}
