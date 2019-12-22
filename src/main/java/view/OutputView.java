package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String ORDER_BOTTOM_LINE = "└ ₩ ┘";
	private static final String TABLE_LIST = "## 테이블 목록";
	private static final String MAIN_SCREEN_LIST = "## 메인화면\n1 - 주문등록\n2 - 결제하기\n3 - 프로그램 종료\n";

	public static void printTables(final List<Table> tables, List<Integer> occupiedTableNumbers) {
		System.out.println(TABLE_LIST);
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printTableBottomLine(tables, occupiedTableNumbers);
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

	private static void printTableBottomLine(final List<Table> tables,
		final List<Integer> occupiedTableNumbers) {
		for (final Table table : tables) {
			printOccupiedTableBottomLine(table, occupiedTableNumbers);
			printUnoccupiedTableBottomLine(table, occupiedTableNumbers);
		}
		System.out.println();
	}

	private static void printOccupiedTableBottomLine(final Table table,
		final List<Integer> occupiedTableNumbers) {
		if (occupiedTableNumbers.contains(table.getNumber())) {
			System.out.print(ORDER_BOTTOM_LINE);
		}
	}

	private static void printUnoccupiedTableBottomLine(final Table table,
		final List<Integer> occupiedTableNumbers) {
		if (!occupiedTableNumbers.contains(table.getNumber())) {
			System.out.print(BOTTOM_LINE);
		}
	}

	public static void printMainScreen() {
		StringBuilder sb = new StringBuilder();
		sb.append(MAIN_SCREEN_LIST);
		System.out.println(sb.toString());
	}

}
