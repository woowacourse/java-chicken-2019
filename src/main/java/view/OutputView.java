package view;

import domain.Menu;
import domain.Orders;
import domain.Table;
import view.dto.OrderDTO;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ %s ┘";
    private static final String NO_ORDER = "-";
    private static final String HAS_ORDER = "₩";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        printLine(TOP_LINE, tables);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final List<Table> tables) {
        for (Table table : tables) {
            String noOrder = getOrderStatus(table);
            System.out.print(String.format(line, noOrder));
        }
        System.out.println();
    }

    private static String getOrderStatus(Table table) {
        if (table.hasNotOrders()) {
            return NO_ORDER;
        }
        return HAS_ORDER;
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printNoOrders() {
        System.out.println("계산할 주문이 없습니다.");
    }

    public static void printOrders(Orders orders) {
        System.out.println("## 주문 내역");
        List<OrderDTO> orderDTOs = orders.getOrders().stream()
                .map(OrderDTO::from)
                .collect(Collectors.toList());

        for (OrderDTO orderDTO : orderDTOs) {
            System.out.println(orderDTO.toString());
        }
    }

    public static void printPaymentPolicy(int number) {
        System.out.println(String.format("## %d번 테이블의 결제를 진행합니다.", number));
    }

    public static void printFinalPrice(double discountPrice) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(discountPrice + "원");
    }

    public static void printErrorLog(String message) {
        System.out.println(message);
    }
}
