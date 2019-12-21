package domain;

import java.util.*;
import java.util.stream.Collectors;

public class TableRepository {
    private static final int FIRST_ORDER = -1;
    private static final List<Table> tables = new ArrayList<>();
    private static List<Integer> orderCheck = new ArrayList<>();
    private static List<Table> tableMenu = tables;

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

    public static void setOrderCheck(int value) {
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).getNumber() == value) {
                orderCheck.add(i);
            }
        }
        orderCheck.stream().sorted();
    }

    public static List<Integer> getOrderCheck() {
        return orderCheck;
    }

    public static void addNewOrder(Table table, int type, int count) {
        Table orderedTable = table;
        orderedTable.addMenu(type, count);

        tableMenu = tableMenu.stream().filter(x -> x.getNumber() != table.getNumber()).collect(Collectors.toList());
        tableMenu.add(table);
        tableMenu.stream().sorted();
    }

    public static List<Table> getTableMenu() {
        return tableMenu;
    }

    public static int totalPayment(Table table) {
        return table.getMenu().stream().mapToInt(Menu::getPrice).reduce(Integer::sum).getAsInt();
    }
}
