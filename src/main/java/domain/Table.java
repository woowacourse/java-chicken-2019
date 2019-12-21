package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private static final int LEFT_MENU_END = 0;
	private final int number;
	private final List<Menu> orderedMenu = new ArrayList<>();

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
}
