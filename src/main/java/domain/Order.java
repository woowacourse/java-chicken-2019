package domain;

public class Order {
	private final Menu menu;
	private final int quantity;

	public Order(Menu menu, int quantity) {
		this.menu = menu;
		this.quantity = quantity;
	}
}
