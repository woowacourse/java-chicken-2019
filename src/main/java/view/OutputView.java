package view;

import domain.Menu;
import domain.Order;
import domain.ProvidingFunction;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String NOT_IN_USE_TABLE_BOTTOM_LINE = "└ ─ ┘";
    private static final String IN_USE_TABLE_BOTTOM_LINE = "└ $ ┘";
    private static final String PROVIDING_FUNCTION_FORMAT = "%d - %s";

    public static void printProvidingFunctions(final List<ProvidingFunction> providingFunctions) {
        System.out.println("## 메인화면");

        for (ProvidingFunction providingFunction : providingFunctions) {
            printProvidingFunction(providingFunction);
            System.out.println();
        }

    }

    private static void printProvidingFunction(final ProvidingFunction providingFunction) {
        System.out.printf(PROVIDING_FUNCTION_FORMAT, providingFunction.getId(), providingFunction.getDescription());
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printTopLine(final int size) {
        printLine(TOP_LINE, size);
    }

    private static void printBottomLine(final List<Table> tables) {

        for (Table table : tables) {
            printOneTableBottom(table.isInUse());
        }

        System.out.println();
    }

    private static void printOneTableBottom(final boolean isInUse) {

        if (isInUse) {
            System.out.print(IN_USE_TABLE_BOTTOM_LINE);
            return;
        }

        System.out.print(NOT_IN_USE_TABLE_BOTTOM_LINE);
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

    public static void printOrders(List<Order> orders) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");

        for (Order order : orders) {
            printOrder(order);
        }

    }

    public static void printPaymentProcessStarted(int tableNumber) {
        System.out.println(tableNumber + "번 테이블의 결제를 진행합니다.");
    }

    private static void printOrder(Order order) {
        System.out.println(order.getMenu().getName() + " "
                + order.getOrderQuantity() + " "
                + order.getMenu().getPrice());
    }

    public static void printTotalPaymentAmount(int totalPaymentAmount) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(totalPaymentAmount + "원");
    }
}
