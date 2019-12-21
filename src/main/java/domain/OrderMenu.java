package domain;

public class OrderMenu extends Menu {
	private Table orderTable;
	private int numberOfMenu;

	public OrderMenu(int number, String name, Category category, int price, int numberOfMenu, OrderTable orderTable) {
		super(number, name, category, price);
		this.orderTable = orderTable;
		this.numberOfMenu = numberOfMenu;
	}

	public boolean checkOrderTableNumber(int tableNumber) {
		return orderTable.containTableNumber(tableNumber);
	}

	public boolean containTableNumber(int tableNumber) {
		return orderTable.containTableNumber(tableNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getName() + " " + numberOfMenu + " " + super.getPrice() * numberOfMenu);
		return sb.toString();
	}
}
