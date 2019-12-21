package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_ORDERED = "└ W ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printBottomLine(final List<Table> tables) {
        for (Table table : tables) {
            if(table.isOrdered == 1) {
                System.out.print(BOTTOM_LINE_ORDERED);
            }
            else if(table.isOrdered == 0) {
                System.out.print(BOTTOM_LINE);
            }
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

    public static void printBills(final Table table) {
        System.out.println("## 주문 내역\n메뉴 수량 금액");
        table.printBill();
        System.out.println();
    }

    public static void printTotal(final Table table, final int payment) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(table.totalPay(payment) + "원");
    }
}
