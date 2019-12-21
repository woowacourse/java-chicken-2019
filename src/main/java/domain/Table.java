package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
	private final int number;
	private Map<Integer, Integer> menuList = new HashMap<>();
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
			this.menuList.put(menuNumber, menuList.get(menuNumber) + menuCount);
			return;
		}
		this.menuList.put(menuNumber, menuCount);
	}

	public String printMenuList() {
		String string = this.number+"번 테이블의 메뉴 수량 금액\n";
		for (int menuNumber : menuList.keySet()) {
			string += MenuRepository.getMenu(menuNumber).toString() + ", 총 " + menuList.get(menuNumber) + "개\n";
		}
		return string;
	}
	
	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
