package view;

import domain.Menu;
import domain.Table;
import function.Order;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_PAY = "└ w ┘";

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

    /**
     * 프로그램 시작시 어떤 기능을 할지 선택지를 보여주는 메소드입니다.
     */
    public static void printMain() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램종료");
    }

    /**
     * 결제할때 나오는 view 결제할 테이블이 있느면 표시가 된다
     *
     * @param tables 테이블 리트스
     */
    public static void printTablesPayment(final List<Table> tables, Map<Table, Integer> map) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLinePayment(size, map);
    }

    private static void printLinePayment(final int count, Map<Table, Integer> map) {
        for (int index = 0; index < count; index++) {
            if (map.get(Order.TABLES.get(index)) != 0) {
                System.out.print(BOTTOM_LINE_PAY);
                continue;
            }
            System.out.print(OutputView.BOTTOM_LINE);
        }
        System.out.println();
    }
}
