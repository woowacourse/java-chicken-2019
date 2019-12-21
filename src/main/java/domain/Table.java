package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Table {
	private static final int MAX_COUNT = 99;

	private final int number;
	private Map<Integer, Integer> menuList;
	private boolean hasCustomer;

	public Table(final int number) {
		this.number = number;
		this.menuList = new HashMap<>();
		this.hasCustomer = false;
	}

	public int getNumber() {
		return this.number;
	}

	public boolean hasCustomer() {
		return this.hasCustomer;
	}

	public void addMenu(int menuNumber, int menuCount) throws Exception {
		if (menuCount > MAX_COUNT || MenuRepository.getMenu(menuNumber) == null) {
			throw new Exception("주문할 수 없는 수량이거나 없는 메뉴입니다.");
		}
		if (menuList.containsKey(menuNumber)) {
			if (menuList.get(menuNumber) + menuCount > MAX_COUNT) {
				throw new Exception("한 메뉴의 최대 수량은 99개입니다. 현재 " + menuList.get(menuNumber) + "개 주문 상태");
			}
			menuList.put(menuNumber, menuList.get(menuNumber) + menuCount);
			hasCustomer = true;
			return;
		}
		menuList.put(menuNumber, menuCount);
		hasCustomer = true;
	}

	public Map<Integer, Integer> getMenuList() {
		return Collections.unmodifiableMap(menuList);
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	public int getPrice() {
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
