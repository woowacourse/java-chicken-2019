package domain;

import static view.InputView.*;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private static final int ZERO = 0;
	private static final int MAX_MENU_COUNT = 99;

	private Menu menu;
	private int count;

	public Order(int menuNumber, int menuCount, List<Menu> menus) {
		this.menu = findMenu(menuNumber, menus);
		if (menuCount > MAX_MENU_COUNT) {
			throw new IllegalArgumentException(OVER_MAX_MENU_COUNT);
		}

		if (menuCount < ZERO) {
			throw new IllegalArgumentException(COUNT_MUST_OVER_ZERO);
		}
		this.count = menuCount;
	}

	public Menu findMenu(int menuNumber, List<Menu> menus) {
		for (Menu menu : menus) {
			if (menu.isThisMenu(menuNumber)) {
				return menu;
			}
		}

		throw new IllegalArgumentException(INVALID_MENU_NUMBER);
	}

}
