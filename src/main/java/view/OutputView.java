package view;

import domain.Menu;
import domain.Table;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_ORDERED = "└ ₩ ┘";
    private static final int DISCOUNT_UNIT = 10000;
    private static final int DISCOUNT_AMOUNT = 10;
    private static final double MONEY_DISCOUNT = 0.95;
    private static final int ENABLE_DISCOUNT = 1;

    public static void printTables(HashMap<Integer, Integer> orderTable, final List<Table> tables) {
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        for(Table table : tables) {
            if(orderTable.containsKey(table.getNumber())) {
                System.out.print(BOTTOM_LINE_ORDERED);
                continue;
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

    public static void printOrderPage() {
        System.out.println("## 메인화면");
        System.out.println("1. 주문등록");
        System.out.println("2. 결제하기");
        System.out.println("3. 프로그램 종료");
    }

    public static void eachPayment(Menu menu, int menuCount) {
        System.out.println(menu.getName() +" "+ menuCount + " " + menu.getPrice()*menuCount);
    }

    public static void moneyPayment(int allPayment) {
        System.out.println("현금 결제를 선택 하셨으므로 5% 가 할인됩니다.");
        System.out.println();
        System.out.println("최종 결제할 금액 " + (int)(allPayment * MONEY_DISCOUNT));
    }

    public static void cardPayMent(int allPayment) {
        System.out.println("최종 결제할 금액 " + allPayment);
    }

    public static void nonePaymentTable() {
        System.out.println("결제할 테이블이 없습니다");
    }

    public static void orderMenu() {
        System.out.println("##주문내역");
        System.out.println("메뉴 수량 금액");
    }


    public static int paymentDiscount(Menu menu, int menuCount) {
        if(menuCount / DISCOUNT_AMOUNT >= ENABLE_DISCOUNT) {
            System.out.println(menu.getName() + "의 수량이 " + menuCount+ " 개 이므로" +
                    menuCount / DISCOUNT_AMOUNT * DISCOUNT_UNIT + "원이 할인됩니다.");
        }
        return menuCount / DISCOUNT_AMOUNT * DISCOUNT_UNIT;
    }

    public static void isWrongTable(HashMap<Integer, Integer> reservedTable, int paymentTable) {
        if(!reservedTable.containsKey(paymentTable)) {
            System.out.println("잘못된 테이블 입니다.");
        }
    }
}
