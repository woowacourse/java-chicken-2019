package domain;

public class TableOrder {
	private final Table table;
	private final Orders orders = new Orders();

	public TableOrder(Table table) {
		this.table = table;
	}
}
