package view;

import domain.Menu;
import domain.Order;
import domain.Table;

import java.util.List;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String ORDER_BOTTOM_LINE = "└ W ┘";
	private static final String ORDER_FORMAT = "%s %d %d\n";

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printBottomLine(tables);
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

	private static void printBottomLine(final List<Table> tables) {
		for (Table table : tables) {
			printOrderLine(table);
		}
		System.out.println();
	}

	private static void printOrderLine(final Table table) {
		if (table.hasOrder()) {
			System.out.print(ORDER_BOTTOM_LINE);
			return;
		}
		System.out.print(BOTTOM_LINE);
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void printOrders(final List<Order> orders) {
		System.out.println("## 주문 내역");
		System.out.println("메뉴 수량 금액");
		for (final Order order : orders) {
			System.out.printf(ORDER_FORMAT, order.menu(), order.amount(), order.price());
		}
		System.out.println();
	}

	public static void printPrice(final int price) {
		System.out.println("## 최종 결제할 금액");
		System.out.println(price);
	}

	public static void printError(final String error) {
		System.out.println(error);
	}
}
