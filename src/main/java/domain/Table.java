package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
	private final int number;
	private Map<Integer, Integer> menuList = new HashMap<>();

	public Table(final int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	public void addMenu(int menuNumber, int menuCount) {
		if(menuList.containsKey(menuNumber)) {
			this.menuList.put(menuNumber, menuList.get(menuNumber) + menuCount);
			return;
		}
		this.menuList.put(menuNumber, menuCount);
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
