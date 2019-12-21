package domain;

public class Order {
	private final Table table;
	private final Menu menu;
	private final Amount amount;

	public Order(Table table, Menu menu, Amount amount) {
		this.table = table;
		this.menu = menu;
		this.amount = amount;
	}
}
