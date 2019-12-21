package view;

import domain.Category;
import domain.Menu;
import domain.Table;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String BOTTOM_LINE_WITH_ORDER = "└(W)┘";
	private static final int MENU_NOT_FOUND = -1;
	private static final Category MENU_NOT_FOUND_IN_CATEGORY = null;
	private static final int CHICKEN = 1;
	private static final int NOT_CHICKEN = 0;
	private static final int DISCOUNT_AMOUNT = 10000;
	private static final int DISCOUNT_DIVIDE = 10;
	private static final int INIT_CHICKEN_COUNT = 0;
	private static final int INIT_PAY_AMOUNT = 0;
	private static final int DISCOUNT_RATE = 95;
	private static final int DISCOUNT_PERCENT = 100;
	private static final int CASH = 2;

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
					+ getPriceByName(entry.getKey(), entry.getValue(), menus));
		}
	}

	private static int getPriceByName(String menuName, Integer count, List<Menu> menus) {
		for (Menu menu : menus) {
			if (menu.getName().equals(menuName)) {
				return menu.getPrice() * count;
			}
		}
		return MENU_NOT_FOUND;
	}

	public static void printTotalPayAmount(Table table, List<Menu> menus, int howToPay) {
		int chickenCount = INIT_CHICKEN_COUNT;
		int moneyToPay = INIT_PAY_AMOUNT;
		Set<Map.Entry<String, Integer>> entries = table.makeResult().entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
			moneyToPay += getPriceByName(entry.getKey(), entry.getValue(), menus);
			chickenCount += checkChicken(entry.getKey(), menus) * entry.getValue();
		}
		moneyToPay = checkDiscount(moneyToPay, chickenCount, howToPay);
		System.out.println("## 최종 결제할 금액");
		System.out.println(moneyToPay + "원\n");
	}

	private static int checkDiscount(int moneyToPay, int chickenCount, int howToPay) {
		moneyToPay -= DISCOUNT_AMOUNT * (chickenCount / DISCOUNT_DIVIDE);
		if (howToPay == CASH) {
			moneyToPay = moneyToPay * DISCOUNT_RATE / DISCOUNT_PERCENT;
		}
		return moneyToPay;
	}

	private static int checkChicken(String menuName, List<Menu> menus) {
		if (getCategoryByName(menuName, menus) == Category.CHICKEN) {
			return CHICKEN;
		}
		return NOT_CHICKEN;
	}

	private static Category getCategoryByName(String menuName, List<Menu> menus) {
		for (Menu menu : menus) {
			if (menu.getName().equals(menuName)) {
				return menu.getCategory();
			}
		}
		return MENU_NOT_FOUND_IN_CATEGORY;
	}
}
