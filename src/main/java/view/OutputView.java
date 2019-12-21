package view;

import domain.Menu;
import domain.Table;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDERED_BOTTOM_LINE = "└ $ ┘";

    private static final String PROGRAM_EXIT = "## 프로그램을 종료합니다.";
    private static final String ANNOUNCE_ORDER_LIST = "## 주문내역";
    private static final String ANNOUNCE_COMLUMNS = "메뉴 수량 금액";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    private static void printBottomLine(final List<Table> tables) {
        for (final Table table : tables) {

            if (table.isOrdered()) {
                System.out.print(ORDERED_BOTTOM_LINE);
            }

            if (!table.isOrdered()) {
                System.out.print(BOTTOM_LINE);
            }

        }
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.printf(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }

        System.out.println();
    }

    public static void printProgramExit() {
        System.out.println(PROGRAM_EXIT);
        System.exit(0);
    }

    public static void printBill(HashMap<Menu, Integer> order) {
        System.out.println(ANNOUNCE_ORDER_LIST);
        System.out.println(ANNOUNCE_COMLUMNS);

        order.forEach((key,value) ->
                System.out.println(key.getName()+ " "+ value + " " + (key.getPrice() * value)));

    }
}
