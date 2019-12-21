package view;

import java.util.List;

import domain.Menu;
import domain.Order;
import domain.Table;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_ALTERNATIVE = "└ ₩ ┘";

    public static void printFeatures() {
        System.out.println("## 메인화면\n"
            + "1 - 주문등록\n"
            + "2 - 결제하기\n"
            + "3 - 프로그램 종료");
        OutputView.printBlankLine();
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
        // TODO: 주문이 존재하는 경우 BOTTOM_LINE 을 "└ ₩ ┘" 으로 교체
        OutputView.printBlankLine();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        printBlankLine();
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

    public static void printOrders(Order order) {
        StringBuilder sb = new StringBuilder("메뉴 수량 금액\n").append(order);
        System.out.println(sb.toString());
        printBlankLine();
    }

    public static void printTotal(double amount) {
        System.out.println("## 최종 결제할 금액\n" + (int)amount + "원");
        printBlankLine();
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
