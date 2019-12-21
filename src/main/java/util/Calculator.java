package util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import domain.Category;
import domain.Menu;
import domain.Table;

public class Calculator {
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

	public static int getPriceByName(String menuName, Integer count, List<Menu> menus) {
		for (Menu menu : menus) {
			if (menu.getName().equals(menuName)) {
				return menu.getPrice() * count;
			}
		}
		return MENU_NOT_FOUND;
	}

	public static Category getCategoryByName(String menuName, List<Menu> menus) {
		for (Menu menu : menus) {
			if (menu.getName().equals(menuName)) {
				return menu.getCategory();
			}
		}
		return MENU_NOT_FOUND_IN_CATEGORY;
	}

	public static int checkDiscount(Table table, List<Menu> menus, int howToPay) {
		int chickenCount = INIT_CHICKEN_COUNT;
		int moneyToPay = INIT_PAY_AMOUNT;
		Set<Map.Entry<String, Integer>> entries = table.makeResult().entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
			moneyToPay += Calculator.getPriceByName(entry.getKey(), entry.getValue(), menus);
			chickenCount += Calculator.checkChicken(entry.getKey(), menus) * entry.getValue();
		}
		moneyToPay -= DISCOUNT_AMOUNT * (chickenCount / DISCOUNT_DIVIDE);
		if (howToPay == CASH) {
			moneyToPay = moneyToPay * DISCOUNT_RATE / DISCOUNT_PERCENT;
		}
		return moneyToPay;
	}

	public static int checkChicken(String menuName, List<Menu> menus) {
		if (getCategoryByName(menuName, menus) == Category.CHICKEN) {
			return CHICKEN;
		}
		return NOT_CHICKEN;
	}
}
