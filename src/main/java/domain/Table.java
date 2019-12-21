package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Table {
	private final int number;
	private static Map<Integer, Integer> menuList = new HashMap<>();
	private boolean hasCustomer;

	public Table(final int number) {
		this.number = number;
		this.hasCustomer = false;
	}

	public int getNumber() {
		return this.number;
	}
	
	public boolean hasCustomer() {
		return this.hasCustomer;
	}

	public void addMenu(int menuNumber, int menuCount) {
		this.hasCustomer = true;
		if(menuList.containsKey(menuNumber)) {
			menuList.put(menuNumber, menuList.get(menuNumber) + menuCount);
			return;
		}
		menuList.put(menuNumber, menuCount);
	}

	public Map<Integer, Integer> getMenuList() {
		return Collections.unmodifiableMap(menuList);
	}
	
	@Override
	public String toString() {
		return Integer.toString(number);
	}

	public static int getPrice() {
		int price = 0;
		for (int menuNumber : menuList.keySet()) {
			Menu menu = MenuRepository.getMenu(menuNumber);
			price += menu.getPrice() * menuList.get(menuNumber);
		}
		return price;
	}

	public void reset() {
		menuList = new HashMap<>();
		hasCustomer = false;
	}
}
