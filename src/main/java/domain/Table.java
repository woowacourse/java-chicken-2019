package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
	private final int number;
	private Map<Menu, Integer> menu = new HashMap<Menu, Integer>();

	public Table(final int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	public int getTableNum() {
		return this.number;
	}

	public boolean isSame(int input) {
		return this.number == input;
	}

	public String toStringInfo() {
		String currentInfo = "## 주문내역\n메뉴/ 수량/ 금액\n";
		for (Menu eachMenu: menu.keySet()) {
			currentInfo += eachMenu.getName() + "/ " 
					+ menu.get(eachMenu) + "/ " + eachMenu.getPrice() + "\n";
		}
		return currentInfo;
	}

	public void addMenu(Menu selectedMenu, int quantity) {
		this.menu.put(selectedMenu, +quantity);
	}

	public int getTotalPrice() {
		int totalPrice = 0;
		for (Menu eachMenu : menu.keySet()) {
			totalPrice += eachMenu.getPrice() * menu.get(eachMenu); // 메뉴의 가격과 수량을 곱한다.
		}
		return totalPrice;
	}

	public int numberOfChickenQty() {
		int chickenQuantity = 0;
		for (Menu eachMenu : menu.keySet()) {
			if (eachMenu.getCategory() == Category.CHICKEN) { // 치킨이면 주문수량만큼 더한다
				chickenQuantity += menu.get(eachMenu);
			}
		}
		return chickenQuantity;
	}
}
