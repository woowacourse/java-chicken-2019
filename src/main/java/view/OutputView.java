package view;

import domain.Menu;
import domain.Table;
import domain.TableMenu;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE_FORMAT = "└ %s ┘";

    public static void printMain() {
        System.out.println();
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println();
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        System.out.println();
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printOrders(final Table table) {
        System.out.println();
        System.out.println("## 주문내역");
        System.out.println("메뉴 수량 금액");
        table.getTableMenus().forEach(OutputView::printTableMenu);
        System.out.println();
        System.out.printf("%d번 테이블의 결제를 진행합니다.\n", table.getNumber());
    }

    public static void printPrices(final Table table) {
        System.out.println("## 최종 결제할 금액");
        System.out.printf("%d원\n", table.calculateTablePrice());
    }

    private static void printTopLine(final String line, final int count) {
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

    private static void printBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.print(makeBottomLine(table));
        }
    }

    private static String makeBottomLine(final Table table) {
        if (table.hasOrder()) {
            return String.format(BOTTOM_LINE_FORMAT, "₩");
        }
        return String.format(BOTTOM_LINE_FORMAT, "-");
    }

    private static void printTableMenu(final TableMenu tableMenu) {
        System.out.println(tableMenu);
    }
}
