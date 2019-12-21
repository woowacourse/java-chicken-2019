package domain;

public class OrderMenu extends Menu {
	private Table orderTable;
	private int numberOfMenu;

	public OrderMenu(int number, String name, Category category, int price, int numberOfMenu, OrderTable orderTable) {
		super(number, name, category, price);
		this.orderTable = orderTable;
	}

}
