package view;

import domain.menu.Menu;
import domain.table.Table;
import domain.table.order.Basket;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String NOT_REQUIRED_PAY_BOTTOM_LINE = "└ ─ ┘";
    private static final String REQUIRED_PAY_BOTTOM_LINE = "└ ₩ ┘";


    public static void printMain() {
        System.out.println("## 메인 화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLineWithPayStatus(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLineWithPayStatus(final List<Table> tables) {
        for (Table table : tables) {
            System.out.print(bottomLineString(table));
        }
        System.out.println();
    }

    private static String bottomLineString(Table table) {
        if (table.isPayProcessingRequire())
            return REQUIRED_PAY_BOTTOM_LINE;
        return NOT_REQUIRED_PAY_BOTTOM_LINE;
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

    public static void printOrderStatus(Table table) {
        System.out.println("## 주문 내역");
        printOrders(table);
    }

    private static void printOrders(Table table) {
        System.out.println("메뉴 수량 금액");
        for (final Basket basket : table.getBaskets()) {
            System.out.println(basket);
        }
        System.out.println();
    }

    public static void printResultPayAccount(int resultAccount) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(resultAccount + "원");
    }

    public static void printTablePayProcessing(Table table) {
        System.out.printf("## %d번 테이블의 결제를 진행합니다", table.getNumber());
        System.out.println();
    }

    public static void printExitMessage() {
        System.out.println("## 치킨집이 닫았습니다 내일 와주세요 (✪‿✪)ノ");
    }

}
