package domain;

public class Order {
	private final int tableNumber;
	private final int menuNumber;
	private final MenuAmount menuAmount;

	public Order(int tableNumber, int menuNumber, MenuAmount menuAmount) {
		this.tableNumber = tableNumber;
		this.menuNumber = menuNumber;
		this.menuAmount = menuAmount;
	}
}
