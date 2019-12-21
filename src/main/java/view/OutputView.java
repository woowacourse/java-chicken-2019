package view;

import domain.Menu;
import domain.Table;
import domain.reserved.OrderedMenu;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String EXIST_ORDER_BOTTOM_LINE = "└ ₩ ┘";
    private static final String SPACE = " ";
    private static final String NEWLINE = "\n";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(size);
        printTableNumbers(tables);
        printBottomLine(BOTTOM_LINE, size, tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printTopLine(final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printBottomLine(final String line, final int count, final List<Table> tables) {
        for (int index = 0; index < count; index++) {
            Table table = tables.get(index);
            if (table.isExistMenu()) {
                System.out.print(EXIST_ORDER_BOTTOM_LINE);
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

    public static void printNoExistTablePayment() {
        System.out.println("결제할 금액이 없습니다.");
        System.out.println("다른 테이블을 입력해주세요.");
    }

    public static void printOrderedMenu(List<OrderedMenu> orderedMenus) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        StringBuilder sb = new StringBuilder();
        orderedMenus.stream()
                .forEach(orderedMenu -> {
                    sb.append(orderedMenu.getName()).append(SPACE);
                    sb.append(orderedMenu.getCapacity().getCapacity()).append(SPACE);
                    sb.append(orderedMenu.getPrice()).append(SPACE);
                    sb.append(NEWLINE);
                });
        System.out.println(sb.toString());
    }
}
