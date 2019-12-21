package view;

import domain.Menu;
import domain.MainFeatureNumber;
import domain.Table;
import domain.TableNumber;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String UNPAID_BOTTOM_LINE = "└ ￦ ┘";

    public static void printMainFeatures() {
        System.out.println("## 메인화면");
        System.out.println(String.format("%d - 주문등록", MainFeatureNumber.ORDER));
        System.out.println(String.format("%d - 결제하기", MainFeatureNumber.PAY));
        System.out.println(String.format("%d - 프로그램 종료", MainFeatureNumber.EXIT));
        System.out.println();
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        for (Table table : tables) {
            if (table.isUnpaidTable()) {
                System.out.print(UNPAID_BOTTOM_LINE);
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
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

    public static void printOrderedMenuList(String unpaidTableOrderedList) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        System.out.println(unpaidTableOrderedList);
    }

    public static void printOrderedMenuPriceSum(double orderedMenuPriceSum) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(orderedMenuPriceSum+"원");
    }
}
