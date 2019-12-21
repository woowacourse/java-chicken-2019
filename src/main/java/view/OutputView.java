package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String ORIGINAL_BOTTOM_LINE = "└ ─ ┘";
    private static final String BEFORE_PAYMENT_BOTTOM_LINE = "└ P ┘";

    public static void printMainScreen() {
        System.out.println("\n## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료\n");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("\n## 테이블 목록");
        final int size = tables.size();
        printTopLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
    }

    private static void printTopLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println("");
    }

    private static void printBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            if (!table.isBeforePayment()) {
                System.out.print(BEFORE_PAYMENT_BOTTOM_LINE);
            }
            if (table.isBeforePayment()) {
                System.out.print(ORIGINAL_BOTTOM_LINE);
            }
        }
        System.out.println("");
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println("");
    }
}
