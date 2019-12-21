package domain;

public class Order {
	private final Table table;
	private final Menu menu;
	private final MenuAmount menuAmount;

	public Order(Table table, Menu menu, MenuAmount menuAmount) {
		this.table = table;
		this.menu = menu;
		this.menuAmount = menuAmount;
	}

	public boolean isTableEquals(int tableNumber) {
		return table.getNumber() == tableNumber;
	}
}
