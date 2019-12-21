package domain;

public class TableOrder {
	private final Table table;
	private final Orders orders = new Orders();

	public TableOrder(Table table) {
		this.table = table;
	}

	public boolean isEqualTable(Table table) {
		return this.table == table;
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
}
