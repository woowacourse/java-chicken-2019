package view;

import domain.Main;
import domain.Menu;
import domain.Order;
import domain.Table;

import java.util.List;

/**
 * @author : Kim SeYun
 * @ClassName : OutputView
 * @ClassExplanation : 출력 UI
 * @Date : 2019. 12. 21
 * @Copyright (c) 2019 SeYun Kim
 */
public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String LINE = "\n";

    public static void printMains(final List<Main> mains) {
        System.out.println(LINE + "## 메인화면");
        mains.stream().forEach(main -> System.out.println(main.toString()));
    }

    public static void printTables(final List<Table> tables) {
        System.out.println(LINE + "## 테이블 목록");
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

    public static void printOrderList(List<Order> tableOrders, int tableNumber){
        System.out.println(LINE + "메뉴 수량 금액");
        tableOrders.stream().forEach(tableOrder -> System.out.println(tableOrder.toString()));
        System.out.println(LINE + "## " + tableNumber + "번 테이블의 결제를 진행합니다.");
    }

    public static void printFinalPayment(int paymentPrice){
        System.out.println(LINE + "## 최종 결제할 금액");
        System.out.println(paymentPrice);
    }

    public static void printProgramExit(){
        System.out.println(LINE + "## 프로그램을 종료합니다.");
    }
}
