package view;

import domain.Action;
import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_2 = "└ ! ┘";

    public static void printActions(final List<Action> actions) {
        System.out.println("## 메인화면");
        for (final Action action: actions) {
            System.out.println(action);
        }
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, tables);
        printTableNumbers(tables);
        printUnderLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final List<Table> tables) {
        for (Table table: tables) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printUnderLine(final List<Table> tables) {
        for (Table table: tables) {
            String line = underLine(table.isEmpty());
            System.out.print(line);
        }
        System.out.println();
    }

    private static String underLine(boolean isEmpty) {
        if (isEmpty) {
            return BOTTOM_LINE;
        }
        return BOTTOM_LINE_2;
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrderHistory(Table table) {
        System.out.println(table.orderHistory());
    }

    public static void printResult(double price) {
        System.out.println("최종 결제할 금액");
        System.out.println(price + "원");
    }

    public static void printAmountWarning() {
        System.out.println("한 메뉴의 수량은 1개 이상 99개 이하여야 합니다.");
    }

    public static void printTableNumWarning() {
        System.out.println("테이블은 1,2,3,5,6,8 중에서 가능합니다.");
    }

    public static void printMenuNumWarning() {
        System.out.println("메뉴판에 있는 번호 중에서 골라야 합니다.");
    }

    public static void printActionNumWarning() {
        System.out.println("1,2,3 중에서 골라야 합니다.");
    }
}
