package view;

import domain.Bills;
import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_FORMAT = "└ %s ┘";
    private static final String WON = "₩";

    public static void printMainView() {
        System.out.println();
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printBills(Bills bills) {
        System.out.println(bills.toString());
    }

    public static void printStartPayment(Table table) {
        System.out.printf("%d번 테이블의 결제를 진행합니다\n", table.getNumber());
    }

    public static void printFinalPayment(int amount) {
        System.out.println();
        System.out.println("## 최종 결제할 금액");
        System.out.printf("%d원\n", amount);
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(BOTTOM_LINE, tables);
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

    private static void printBottomLine(final String line, List<Table> tables) {
        for (Table table : tables) {
            if (table.isNoOrder()) {
                System.out.print(line);
                continue;
            }
            System.out.printf(BOTTOM_LINE_FORMAT, WON);
        }
        System.out.println();
    }

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
