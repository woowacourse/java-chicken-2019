package view;

import domain.Bill;
import domain.Menu;
import domain.Order;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String ORDER_FUNCTION_MESSAGE = "1 - 주문등록";
    private static final String PAY_FUNCTION_MESSAGE = "2 - 결제하기";
    private static final String EXIT_FUNCTION_MESSAGE = "3 - 프로그램 종료";
    private static final String MENU_COUNT_PRICE = "메뉴 수량 금액";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE_FORMAT = "└ %s ┘";
    private static final String LINE = "─";
    private static final String ORDERED = "₩";
    private static final String EXIT_PROGRAM_MESSAGE = "프로그램이 종료됩니다.";

    public static void printMain() {
        System.out.println("## 메인 화면");
        System.out.println(ORDER_FUNCTION_MESSAGE);
        System.out.println(PAY_FUNCTION_MESSAGE);
        System.out.println(EXIT_FUNCTION_MESSAGE);
        System.out.println();
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(BOTTOM_LINE_FORMAT, size, tables);
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printTopLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(final String line, final int count, List<Table> tables) {
        for (Table table : tables) {
            if (table.getBill().hasOrder()) {
                System.out.printf(BOTTOM_LINE_FORMAT, ORDERED);
                continue;
            }
            System.out.printf(BOTTOM_LINE_FORMAT, LINE);
        }
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printBill(Table table) {
        Bill bill = table.getBill();
        System.out.println(MENU_COUNT_PRICE);
        for (Order order : bill.getOrders()) {
            System.out.println(order);
        }
        System.out.println();
    }

    public static void printProgramExit() {
        System.out.println(EXIT_PROGRAM_MESSAGE);
    }
}
