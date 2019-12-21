package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDERED_BOTTOM_LINE = "└ $ ┘";

    public static void printMainUI() {
        System.out.println("## 메인화면");
        System.out.println("1. 주문하기");
        System.out.println("2. 결제하기");
        System.out.println("3. 프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        printTopLine(tables);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printPayment(Table table) {
        List<String> paymentList = table.getPaymentList();
        for (String payment : paymentList) {
            System.out.println(payment);
        }
        System.out.println();
        System.out.println("## " + table.toString() + "번 테이블의 결제를 진행합니다.");
    }

    public static void printExit() {
        System.out.println("프로그램을 종료합니다.");
    }

    private static void printTopLine(final List<Table> tables) {
        for (Table table : tables) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printBottomLine(final List<Table> tables) {
        for (Table table : tables) {
            System.out.print(bottomLineStyle(table));
        }
        System.out.println();
    }

    private static String bottomLineStyle(final Table table) {
        if (table.isOrderedTable()) {
            return ORDERED_BOTTOM_LINE;
        }
        return BOTTOM_LINE;
    }
}
