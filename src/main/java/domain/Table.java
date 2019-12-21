package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
	private final int number;
	// private final List<Menu> menus = new ArrayList<Menu>();
	private final Map<Menu, Integer> menus = new HashMap<Menu, Integer>();

	public Table(final int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	public Map<Menu, Integer> getMenus() {
		return this.menus;
	}

	public void add(Menu inputMenu, int menuCount) {
		if (menus.get(inputMenu) != null) {
			menus.put(inputMenu, menus.get(inputMenu) + menuCount);
			return;
		}
		menus.put(inputMenu, menuCount);
		// 예외처리 필요
	}

	public boolean isEmpty() {
		return this.menus.isEmpty();
	}

	public List<String> orderedMenuToString() {
		List<String> result = new ArrayList<String>();
		for (Map.Entry<Menu, Integer> menu : menus.entrySet()) {
			result.add(menu.getKey().getName() + " " + menu.getValue() + " " + menu.getKey().getPrice());
		}
		return result;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

}
