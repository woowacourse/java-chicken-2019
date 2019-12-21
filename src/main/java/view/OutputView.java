package view;

import domain.Menu;
import domain.OrderedMenu;
import domain.Table;
import service.Service;

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

    public static void printServices(final List<Service> services){
        for (final Service service : services) {
            System.out.println(service.toString());
        }
        System.out.println();
    }

    public static void printOrderedMenu(final List<OrderedMenu> orderedMenus){
        System.out.println("## 주문내역");
        System.out.println("메뉴 수량 가격");
        for(OrderedMenu menu : orderedMenus){
            System.out.println(menu.toString());
        }
    }

    public static void printStartCalculatingPrice(Table table){
        System.out.println(table.getTableNumber()+"의 결제를 진행합니다.");
    }

    public static void printTotalPrice(int price){
        System.out.println("## 최종 결제할 금액");
        System.out.println(price +"원");
    }
}
