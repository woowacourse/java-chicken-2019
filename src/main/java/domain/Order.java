package domain;

public class Order {
	private static final int CHICKEN_SALE_UNIT = 10;
	private static final int CHICKEN_SALE_PRICE = 10000;

	private final Table table;
	private final Menu menu;
	private final Amount amount;

	public Order(Table table, Menu menu, Amount amount) {
		this.table = table;
		this.menu = menu;
		this.amount = amount;
	}

	public String menu() {
		return menu.getName();
	}

	public int amount() {
		return amount.get();
	}

	public int price() {
		return menu.getPrice() * amount();
	}

}
