package view;

import domain.Menu;
import domain.Table;
import domain.Tables;

import java.util.List;

public class OutputView {

    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String OPTIONAL_BOTTOM_LINE = "└ \\ ┘";

    public static void printMainMenus() {
        System.out.println("## 메인화면");
        System.out.println("1 -  주문등록");
        System.out.println("2 -  결제하기");
        System.out.println("3 -  프로그램 종료");
        System.out.println();
    }

    public static void printTables( final Tables tables ) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        for (Table table : tables.tables()) {
            if (table.hasOrder()) {
                System.out.print(OPTIONAL_BOTTOM_LINE);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
    }

    public static void printMenus( final List<Menu> menus ) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine( final String line, final int count ) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers( final Tables tables ) {
        for (final Table table : tables.tables()) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrderAmount( double amount ) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(amount + "원");
    }

    public static void printEndProgram() {
        System.out.println("=======================");
        System.out.println("프로그램을 종료합니다.");
        System.out.println("=======================");
    }

    public static void printNoOrder() {
        System.out.println("================");
        System.out.println("주문이 없습니다");
        System.out.println("================");
    }

    public static void printNotAbleOrder() {
        System.out.println("================");
        System.out.println("주문 수량이 99가 넘습니다.");
        System.out.println("================");
    }
}
