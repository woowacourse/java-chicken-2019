package view;

import domain.Menu;
import domain.Order;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDERED_BOTTOM_LINE = "└ ₩ ┘";
    private static final String NEW_LINE = "\n";


    public static void printPosMenu(){
        System.out.println("## 메인화면");
        System.out.println("## 1 - 주문등록");
        System.out.println("## 2 - 결제하기");
        System.out.println("## 3 - 프로그램 종료" + NEW_LINE);
    }

    public static void printTables(final List<Table> tables, int tableNumber){
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printOrderedLine(BOTTOM_LINE, size, tables, tableNumber);
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

    private static void printOrderedLine(final String line, final int count, List<Table> tables, int tableNumber) {
        for (int index = 0; index < count; index++) {
            if (tables.get(index).isMatchNumber(tableNumber)) {
                System.out.print(ORDERED_BOTTOM_LINE);
                continue;
            }
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

    public static void printOrderList(String orderList) {
        System.out.println(NEW_LINE + "## 주문 내역 "+ NEW_LINE + "메뉴 수량 금액");
        System.out.println(orderList);
    }

    public static void printPayingStartMessage(int tableNumber) {
        System.out.println(tableNumber + "번 테이블의 결제를 진행합니다.");
    }

    public static void printFinalPaymentPrice(double finalPaymentPrice) {
        System.out.println(NEW_LINE + "## 최종 결제할 금액");
        System.out.println(finalPaymentPrice + "원" + NEW_LINE);
    }

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
