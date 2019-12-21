package view;

import java.util.List;
import java.util.Map;
import java.util.Set;

import domain.Menu;
import domain.Table;
import util.Calculator;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String BOTTOM_LINE_WITH_ORDER = "└(W)┘";

	public static void printTables(final List<Table> tables) {
		System.out.println("\n## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printLine(size, tables);
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

	private static void printLine(final int count, final List<Table> tables) {
		for (int index = 0; index < count; index++) {
			if (tables.get(index).getOrderCount() > 0) {
				System.out.print(BOTTOM_LINE_WITH_ORDER);
			}
			if (tables.get(index).getOrderCount() == 0) {
				System.out.print(BOTTOM_LINE);
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

	public static void printCanNotOrder() {
		System.out.println("해당 테이블은 더 이상 주문할 수 없습니다.");
	}

	public static void printCanNotPayment() {
		System.out.println("해당 테이블은 결제할 수 없습니다.");

	}

	public static void printOrders(Table table, List<Menu> menus) {
		Set<Map.Entry<String, Integer>> entries = table.makeResult().entrySet();
		System.out.println("\n## 주문 내역");
		System.out.println("메뉴 수량 금액");
		for (Map.Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + " " + entry.getValue() + " "
					+ Calculator.getPriceByName(entry.getKey(), entry.getValue(), menus));
		}
	}

	public static void printTotalPayAmount(Table table, List<Menu> menus, int howToPay) {
		System.out.println("## 최종 결제할 금액");
		System.out.println(Calculator.checkDiscount(table, menus, howToPay) + "원\n");
	}
}
