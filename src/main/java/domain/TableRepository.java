package domain;

import java.util.ArrayList;
import java.util.Collections;
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

    public static boolean doesNotExistTableNumber(int tableNumber) {
        for (Table table : tables) {
            if (table.isSameTableNumber(tableNumber)) {
                return false;
            }
        }
        return true;
    }

    public static void addOrderToTable(TableNumber tableNumber, MenuNumber menuNumber, MenuCount menuCount) {
        for (Table table : tables) {
            if (table.isSameTableNumber(tableNumber.get())) {
                table.getOrderedMenu(menuNumber, menuCount);
                break;
            }
        }
    }
}
