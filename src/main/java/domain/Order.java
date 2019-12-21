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

	public String menuAccounts() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(menu.getName());
		stringBuilder.append("\t");
		stringBuilder.append(menuAmount.getAmount());
		stringBuilder.append("\t");
		stringBuilder.append(menu.getPrice() * menuAmount.getAmount());
		stringBuilder.append("\n");
		return stringBuilder.toString();
	}

	public int getPrice() {
		return menu.getPrice() * menuAmount.getAmount();
	}

	public boolean isCategoryEquals(String name) {
		return menu.getCategory().toString().equals(name);
	}
}
