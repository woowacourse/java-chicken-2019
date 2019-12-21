package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String HYPHEN = "-";
    public static final int ORDER_MENU = 1;
    public static final int PAY_MENU = 2;
    public static final int EXIT_PROGRAM = 3;

    public static void printMain() {
        System.out.println("## 메인 화면");
        System.out.println(ORDER_MENU + HYPHEN + "주문등록");
        System.out.println(PAY_MENU + HYPHEN + "결제하기");
        System.out.println(EXIT_PROGRAM + HYPHEN + "프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
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
}
