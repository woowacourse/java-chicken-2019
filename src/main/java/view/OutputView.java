package view;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

import java.util.List;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String BOTTOM_LINE_WITH_CHECK = "└ @ ┘";

	public static void mainDisplay() {
		System.out.println("##메인 화면");
		System.out.println("1 - 주문등록");
		System.out.println("2 - 결제하기");
		System.out.println("3 - 프로그램 종료");
	}

	public static void printTables(final TableRepository tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printTopLine(size);
		printTableNumbers(tables);
		printBottomLine(tables);
	}

	public static void printMenus(final MenuRepository menus) {
		for (final Menu menu : menus.getMenus()) {
			System.out.println(menu);
		}
	}

	private static void printTopLine(final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(TOP_LINE);
		}
		System.out.println();
	}

	private static void printTableNumbers(final TableRepository tables) {
		for (final Table table : tables.getTables()) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	private static void printBottomLine(final TableRepository tables) {
		for (final Table table : tables.getTables()) {
			if (table.isEmpty()) {
				System.out.printf(BOTTOM_LINE, table);
				continue;
			}
			System.out.printf(BOTTOM_LINE_WITH_CHECK, table);
		}
		System.out.println();
	}

	public static void printAllMenuesOfTable(Table table) {
		System.out.println("## 주문 내역");
		System.out.println("메뉴 수량 금액");
		for (Menu menu : table.getMenus()) {
			System.out.println(menu.orderedMenuToString());
		}
	}
}
