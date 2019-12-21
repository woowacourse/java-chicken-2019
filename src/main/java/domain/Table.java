package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private final int number;
	private final List<Menu> menus = new ArrayList<Menu>();

	public Table(final int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	public void add(Menu menu, int menuCount) {
		for (int i = 0; i < menuCount; i++) {
			menus.add(menu);
		}
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

}
