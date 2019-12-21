package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private final List<Menu> menus = new ArrayList<>();
	private final int number;
	private boolean use = false;

	public Table(final int number) {
		this.number = number;
	}

	public void addMenus(int menuNumber, int menuCount) {
		for (int i = 0; i < menuCount; i++) {
			menus.add(MenuRepository.menus().stream()
				.filter(menu -> menu.getNumber() == menuNumber)
				.findFirst()
				.get());
		}
		use = true;
	}

	public boolean isUse() {
		return use;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
