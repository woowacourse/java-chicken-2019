package view;

import domain.Menu;
import domain.Table;
import constant.ProjectConstant;

import java.util.List;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String ORDER_BOTTOM_LINE = "└ W ┘";

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		for (Table t : tables) {
			printTableBottomLine(t);
		}
		System.out.println();
	}

	public static void printMenus(final List<Menu> menus) {
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

	private static void printTableBottomLine(Table table) {
		if (table.getMenuListSize() == ProjectConstant.ZERO) {
			System.out.print(BOTTOM_LINE);
		}
		if (table.getMenuListSize() != ProjectConstant.ZERO) {
			System.out.print(ORDER_BOTTOM_LINE);
		}

	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void printNotNumber() {
		System.out.println("숫자를 입력해 주세요.");
	}

	public static void printOrderMenuError() {
		System.out.println("메뉴 번호를 다시 입력해 주세요.");
	}

	public static void printMenuCountError() {
		System.out.println("메뉴 수량을 다시 입력해 주세요.");
	}
	
	public static void printSelectOrderedTable() {
		System.out.println("주문이 있는 테이블을 선택해 주세요.");
	}
	
	public static void printAmount(double amount) {
		System.out.println("\r\n## 최종 결제할 금액");
		System.out.println(String.format("%1$,.0f", amount) + "원\r\n");
	}
}
