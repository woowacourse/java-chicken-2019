package view;

import domain.Menu;
import domain.Table;

import java.util.List;

/**
 * OutputView.java
 * 화면에 글자를 출력하는 클래스
 * 우아한테크코스 최종 오프라인 테스트
 * (c) hothead factory. 정회형
 */

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_HAS_ORDER = "└ $ ┘";

    public static void printMainMenu() {
        System.out.println("\n## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("\n## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printOrderStatus(tables);
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

    private static void printOrderStatus(List<Table> tables) {
        for ( Table table : tables ) {
            if(table.hasOrder()) {
                System.out.print(BOTTOM_LINE_HAS_ORDER);
            }
            if(!table.hasOrder()) {
                System.out.print(BOTTOM_LINE);
            }
        }
        System.out.println();
    }
}
