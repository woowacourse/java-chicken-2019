/*
 * OutputView
 *
 * ver 1.0
 *
 * 2019.12.21
 *
 * CopyRight
 *
 */
package view;

import domain.Menu;
import domain.Pay;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printTables(final List<Table> tables, List<Pay> payList) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size, payList);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size, payList);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count, List<Pay> payList) {
        for (int index = 0; index < count; index++) {
            if (payList.get(index).getCount() > 0) {
                System.out.print("- $ -"); // 만약 주문이 한건이라도 있다면 출력으로 표시해준다.
            } else {
                System.out.print(line);
            }
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printFunction() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printResults(List<String> orderedMenu) {
        System.out.println("## 주문내역");
        System.out.println("메뉴  수량  금액");
        for (String result : orderedMenu) {
            System.out.println(result);
        }
    }

    public static void printPay(int tablePay) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(tablePay + "원");
    }
}
