package domain;

import java.util.ArrayList;
import java.util.List;

public class TotalOrders {
	private final List<TableOrder> totalOrders = new ArrayList<>();

	public TotalOrders() {
		List<Table> tables = TableRepository.tables();
		for (Table table : tables) {
			totalOrders.add(new TableOrder(table));
		}
	}
}
