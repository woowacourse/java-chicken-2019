/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * OutputView.java
 * 출력을 담당하는 객체
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        21 Dec 2019
 *
 */

package view;

import java.util.List;

import domain.Menu;
import domain.Order;
import domain.Table;
import util.Message;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE_OF_EMPTY_TABLE = "└ ─ ┘";
    private static final String BOTTOM_LINE_OF_ORDER_TABLE = "└ \\ ┘";

    public static void printActionList() {
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printTableBottom(tables);
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printTableBottom(final List<Table> tables) {
        for (Table table : tables) {
            if (table.hasOrder()) {
                System.out.printf(BOTTOM_LINE_OF_ORDER_TABLE, table);
                continue;
            }
            System.out.printf(BOTTOM_LINE_OF_EMPTY_TABLE, table);
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

    public static void printOrders(final List<Order> orders) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (final Order order : orders) {
            System.out.println(order.getMenu().toString());
        }
    }

    public static void printPayMethod(Table table) {
        System.out.println("## " + table.toString() + "번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용 카드는 1번, 현금은 2번");
    }

    public static void printPayment(String price) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(price);
    }

    public static void printCantPay() {
        System.out.println(Message.CANT_PAY_ERROR.getMessage());
    }
}
