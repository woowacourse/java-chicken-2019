package domain;

public class TableOrder {
	private final Table table;
	private final Orders orders = new Orders();

	public TableOrder(Table table) {
		this.table = table;
	}

	public boolean isEqualTable(Table table) {
		return this.table.equals(table);
	}

	public void add(Order order) {
		orders.add(order);
	}

	public void removeOrdersInfo() {
		orders.removeAll();
	}

	public Cost getAllOriginCost() {
		return orders.getAllCost();
	}

	public boolean isAbleToOrderMenu(Menu menu, int additionalQuantity) {
		return orders.isAbleToOrderMenu(menu, additionalQuantity);
	}

	public int getCountOfChickenOrder() {
		return orders.getCountOfChickenOrder();
	}

	@Override
	public String toString() {
		return orders.toString();
	}


}
