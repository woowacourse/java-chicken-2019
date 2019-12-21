package view;

import domain.Menu;
import domain.OrderBoard;
import domain.Table;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static int[] printMenus(final List<Menu> menus) {
        System.out.println();
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        return new InputView().inputMenu(menus);
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

    public static int printMainScreen() {
        System.out.println("##메인 화면\n1 - 주문등록\n2 - 결제하기\n3 - 프로그램 종료");
        return new InputView().inputFunction();
    }

    public static void printOrderList(int tableNumber, OrderBoard orderBoard) {
        System.out.println("주문 내역\n메뉴  수량  금액");

    }

}
