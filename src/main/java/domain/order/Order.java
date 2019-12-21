package domain.order;

import domain.purchase.Cost;
import domain.food.Menu;

public class Order {
	private final Menu menu;
	private final int quantity;

	public Order(Menu menu, int quantity) {
		this.menu = menu;
		this.quantity = quantity;
	}

	public boolean isEqualMenu(Menu menu) {
		return this.menu == menu;
	}

	public int getQuantity() {
		return quantity;
	}

	public Cost getCost() {
		return menu.calculateCost(quantity);
	}

	public boolean isChicken() {
		return menu.isChicken();
	}

	@Override
	public String toString() {
		return menu.getName() + " " + quantity + " " + menu.getPrice();
	}
}
