package view;

import java.util.List;

import domain.Menu;
import domain.Table;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ - ┘";
	private static final String BOTTOM_LINE_FORMAT = "└ %s ┘";
	private static final String WON = "￦";

	public static void printMainMenu() {
		System.out.println("## 메인화면\n"
			+ "1 - 주문등록\n"
			+ "2 - 결제하기\n"
			+ "3 - 프로그램 종료\n");
	}

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printOrderedTable(tables);
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

	private static void printOrderedTable(final List<Table> tables) {
		for (final Table table : tables) {
			if (table.isUse()) {
				System.out.printf(BOTTOM_LINE_FORMAT, WON);
				continue;
			}
			System.out.print(BOTTOM_LINE);
		}
		System.out.println();
	}

	public static void printOrderedList(String totalOrder) {
		System.out.println(totalOrder);
	}
}
