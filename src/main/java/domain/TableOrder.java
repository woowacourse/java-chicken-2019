package domain;

public class TableOrder {
	private final Table table;
	private final Orders orders;

	public TableOrder(Table table, Orders orders) {
		this.table = table;
		this.orders = orders;
	}
}
