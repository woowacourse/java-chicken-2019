package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
	private static final int LEFT_MENU_END = 0;
	private final int number;
	private final List<Menu> orderedMenu = new ArrayList<>();
	private final Map<String, Integer> orderedMenuCount = new HashMap<>();

	public Table(final int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	public int getNumber() {
		return number;
	}

	public int getOrderCount() {
		return orderedMenu.size();
	}

	public void addToOrderedMenu(Menu newOrder, int menuCount) {
		while (menuCount-- > LEFT_MENU_END) {
			orderedMenu.add(newOrder);
		}
	}

	public Map<String, Integer> makeResult() {
		orderedMenuCount.clear();
		for (Menu menu : orderedMenu) {
			if (orderedMenuCount.containsKey(menu.getName()) == true) {
				orderedMenuCount.put(menu.getName(), orderedMenuCount.get(menu.getName()) + 1);
			}
			if (orderedMenuCount.containsKey(menu.getName()) == false) {
				orderedMenuCount.put(menu.getName(), 1);
			}
		}
		return orderedMenuCount;
	}
}
