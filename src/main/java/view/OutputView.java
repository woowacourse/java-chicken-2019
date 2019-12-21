package view;

import java.util.List;
import java.util.Map;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ %s ┘";

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printBottomLine(BOTTOM_LINE, tables, size);
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

	private static void printBottomLine(final String line, final List<Table> tables, final int count) {
		for (final Table table : tables) {
			if (table.hasCustomer()) {
				System.out.printf(line, "\\");
				continue;
			}
			System.out.printf(line, "-");
		}
		System.out.println();
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void printMainMenu() {
		System.out.println("## 메인메뉴");
		System.out.println("1-주문등록");
		System.out.println("2-결제하기");
		System.out.println("3-프로그램 종료");
	}

	public static void printTableMenu(int tableNumber) {
		System.out.println("## 주문내역");
		System.out.println(tableNumber + "번 테이블의 메뉴 수량 금액");
		Map<Integer, Integer> menuList = TableRepository.getTable(tableNumber).getMenuList();
		for (int menuNumber : menuList.keySet()) {
			System.out.println(MenuRepository.getMenu(menuNumber).toString() + ", 총 " + menuList.get(menuNumber) + "개");
		}
		System.out.println();
		System.out.println("## " + tableNumber + "번 테이블의 결제를 진행합니다");
	}

	public static void printPrice(int price) {
		System.out.println("## 최종 결제할 금액");
		System.out.println(price + "원\n");
	}
}
