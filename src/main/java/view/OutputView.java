package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import domain.Menu;
import domain.Table;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String BEFORE_PAYMENT = "└ ￦┘";
	private static final String GET_ORDER = "1. 주문등록";
	private static final String PAY = "2. 결제하기";
	private static final String EXIT_PROGRAM = "3. 프로그램 종료하기";
	private static final String ORDER_LIST = "## 주문 내역";
	private static final String MENU_QUANTITY_PRICE = "메뉴 수량 금액";
	private static final String FINAL_MONEY = "## 최종금액";
	private static final Scanner scanner = new Scanner(System.in);

	public static void printMain() {
		System.out.println("## 메인화면 ");
		System.out.println(GET_ORDER);
		System.out.println(PAY);
		System.out.println(EXIT_PROGRAM);
	}

	public static void printTables(final List<Table> tables) {
		List<Integer> orderedTables = new ArrayList<>();
		orderedTables = tables.stream().map(Table::isOrderedTable).filter(num -> num != -1)
				.collect(Collectors.toList());
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printTopLine(TOP_LINE, size);
		printTableNumbers(tables);
		printBottomLine(BOTTOM_LINE, tables, orderedTables);
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
	}

	private static void printTopLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		System.out.println();
	}

	private static void printBottomLine(final String line, List<Table> tables, List<Integer> orderedTables) {
		for (Table table : tables) {
			if (orderedTables.contains(table.getTableNumber())) {
				System.out.print(BEFORE_PAYMENT);
			} else if (!orderedTables.contains(table.getTableNumber())) {
				System.out.print(line);
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

	public static void printOrderedList(List<Table> tables, int tableNumber, List<Menu> menus) {
		for (Table table : tables) {
			if (tableNumber == table.getTableNumber()) {
				System.out.println(ORDER_LIST);
				System.out.println(MENU_QUANTITY_PRICE);
				printMenuQuantityPrice(table.printOrderList(menus));
			}
		}
	}

	private static void printMenuQuantityPrice(List<String> orderList) {
		for (String order : orderList) {
			System.out.println(order);
		}
	}
	
	public static void printFinalMoney(double finalMoney) {
		System.out.println(FINAL_MONEY);
		System.out.println(finalMoney);
	}

}
