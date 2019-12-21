package view;

import domain.Menu;
import domain.Order;
import domain.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "|  %s   |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_CASH_LINE = "└ $ ┘";

    public static void printEndPos() {
        System.out.println("## 포스기를 종료합니다.");
    }

    public static void printTables(final List<Table> tables, Map<Table, List<Order>> tableOrders) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printTableBottomLine(tables, tableOrders);
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printOrderCountExceed() {
        System.out.println("최대 주문 제한 개수를 초과하여 구매할 수 없습니다.");
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printTableBottomLine(final List<Table> tables, Map<Table, List<Order>> tableOrders) {
        for (final Table table : tables) {
            printTableBottomLine(tableOrders.get(table).size());
        }
        System.out.println();
    }

    private static void printTableBottomLine(int tableOrderCount) {
        if (tableOrderCount == 0) {
            System.out.print(BOTTOM_LINE);
        }
        if (tableOrderCount != 0) {
            System.out.print(BOTTOM_CASH_LINE);
        }
    }
}
