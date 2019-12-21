package view;

import java.util.List;

import domain.Menu;
import domain.Order;
import domain.PaymentOption;
import domain.Table;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String PAY_LINE = "└ ₩ ┘";
    
    public static void printFunction() {
    	System.out.println("## 메인화면\n1 - 주문등록\n2 - 결제하기\n3 - 프로그램 종료\n");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLastLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
    	System.out.println();
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }
    
    private static void printLastLine(final List<Table> tables) {
        for (final Table table : tables) {    	
            System.out.print(checkOrder(table));
        }
        System.out.println();
    }
    
    private static String checkOrder(Table table) {
    	if (table.toOrders().hasNotOrder()) {
    		return BOTTOM_LINE;
    	}
    	return PAY_LINE;
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }
    
    public static void printOrderList(final Table table) {
    	System.out.println("\n## 주문내역\n메뉴 수량 금액");
    	
    	for (Order order : table.toOrders().toList()) {
    		System.out.println(order.toString());
    	}
    	System.out.println();
    }
    
    public static void printPayingProcess(final Table table) {
    	System.out.println(table.toString() + "번 테이블의 결제를 진행합니다.");
    }
    
    public static void printAllPrice(final Table table, final PaymentOption paymentOption) {
    	System.out.println("\n## 최종 결제할 금액");
    	System.out.println(table.toOrders().toAllPrice(paymentOption)+ "\n");
    }
}