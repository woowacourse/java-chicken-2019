package view;

import domain.Menu;
import domain.Table;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_ORDER_EXIST = "└ ₩ ┘";

    public static void printMainOption() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문 등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("\n## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printTableStatus(tables);
    }

    public static void printTableChoiceError() {
        System.out.println("\n주문이 없는 테이블 입니다.");
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

    private static void printTableStatus(final List<Table> tables) {
        for (final Table table : tables) {
            if (table.isOrder()) {
                System.out.print(BOTTOM_LINE_ORDER_EXIST);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
    }

    public static void printOrderForCheckOut() {
        System.out.println("\n## 주문 내역");
        System.out.println("메뉴  수량  주문");
    }

    public static void printResult(int total) {
        System.out.println("\n## 최종 결제할 금액");
        System.out.println(total + "원\n");
    }

    public static void howToCheckOut(int number) {
        System.out.println("\n# " + number + "번 테이블의 결제를 진행합니다.");
    }

    public static void printEndMessage() {
        System.out.println("\n프로그램을 종료합니다.");
    }
}
