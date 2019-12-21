package view;

import domain.Menu;
import domain.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDERED_BOTTOM_LINE = "└ ₩ ┘";

    public static void printMain() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료\n");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables, size);
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
    }

    public static void printMenusOrdered(Table table) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (Entry<Menu, Integer> menuOrdered : table.getMenuOrdered().entrySet()) {
            System.out.print(menuOrdered.getKey().getName()+" ");
            System.out.print(menuOrdered.getValue()+" ");
            System.out.println(menuOrdered.getKey().getPrice()*menuOrdered.getValue());
        }
        System.out.println();
    }

    public static void printPayment(Table table) {
        System.out.println("## "+table.getNumber()+"번 테이블의 결제를 진행합니다.");
    }

    public static void printSumOfMoneyInstruction () {
        System.out.println("최종 결제할 금액");
    }

    public static void printSumOfMoney(Table table) {
        System.out.println(table.getMoneyCharged()+"원");
        System.out.println();
    }
    public static void printSumOfMoneyCash(Table table) {
        System.out.println(table.getMoneyCharged()*0.95+"원");
        System.out.println();
    }

    public static void printTerminatingProgram() {
        System.out.println("## 프로그램을 종료합니다.");
    }

    public static void printInvalidMainInput() {
        System.out.println("원하는 기능은 1,2,3 중에 선택하여 주십시오.");
    }

    public static void printInvalidTableNumber() {
        System.out.println("없는 테이블 번호입니다.");
    }

    public static void printInvalidMenuNumber() {
        System.out.println("없는 메뉴 번호입니다.");
    }

    public static void printQuantityLimit() {
        System.out.println("한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개입니다.");
    }

    public static void printInvalidPaymentMethodInput() {
        System.out.println("결제 방법은 1,2 중에 선택하여 주십시오.");
    }

    public static void printInputMisMatchException() {
        System.out.println("입력값이 유효하지 않습니다.");
    }


    private static void printTopLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(List<Table> tables, final int count) {
        String line = "";
        for (Table table: tables) {
            if (table.hasOrdered() == false) {
                System.out.print(BOTTOM_LINE);
                continue;
            }
            System.out.print(ORDERED_BOTTOM_LINE);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }
}
