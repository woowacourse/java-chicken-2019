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

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void add(Menu menu, int menuCount) {
		for (int i = 0; i < menuCount; i++) {
			menus.add(menu);
		}
		// 예외처리 필요
	}

	public boolean isEmpty() {
		return this.menus.isEmpty();
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

}
