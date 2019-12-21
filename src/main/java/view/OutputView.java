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
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printMainMenu() {
        System.out.println("## 메인 화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 종료");
    }

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
}
