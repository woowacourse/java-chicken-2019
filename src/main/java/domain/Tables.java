package domain;

import java.util.List;

public class Tables {

    private static List<Table> tables;

    public Tables( List<Table> tables ) {
        this.tables = tables;
    }

    public List<Table> tables() {
        return tables;
    }

    public Table getTable( int tableNumber ) {
        Table current = null;
        for (Table table : tables) {
            if (table.isEqual(tableNumber)) {
                current = table;
            }
        }
        return current;
    }

    public static void addOrder( int tableNumber, Order order ) {
        for (Table table : tables) {
            if (table.isEqual(tableNumber)) {
                table.addOrder(order);
            }
        }
    }

    public static int size() {
        return tables.size();
    }

    public static void payment( int tableNumber ) {
        for (Table table : tables) {
            if (table.isEqual(tableNumber)) {
                table.clearOrder();
            }
        }
    }

    public static boolean hallIsEmpty() {
        boolean isEmpty = true;
        for (Table table : tables) {
            if (table.hasOrder()) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }
}
