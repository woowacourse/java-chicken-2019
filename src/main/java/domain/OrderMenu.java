package domain;

public class OrderMenu extends Menu {
	private static final String CHICKEN = "CHICKEN";
	private Table orderTable;
	private int numberOfMenu;

	public OrderMenu(int number, String name, Category category, int price, int numberOfMenu, OrderTable orderTable) {
		super(number, name, category, price);
		this.orderTable = orderTable;
		this.numberOfMenu = numberOfMenu;
	}

	public int getNumberOfMenu() {
		return numberOfMenu;
	}

	public boolean containTableNumber(int tableNumber) {
		return orderTable.containTableNumber(tableNumber);
	}

	public boolean isChicken() {
		return super.getCategory().equals(CHICKEN);
	}

	public int getTotalPrice() {
		return super.getPrice() * numberOfMenu;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getName() + " " + numberOfMenu + " " + super.getPrice() * numberOfMenu);
		return sb.toString();
	}
}
