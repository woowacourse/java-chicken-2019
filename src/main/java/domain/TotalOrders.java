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

	public void addOrder(Table table, Order order) {
		for (TableOrder tableOrder : totalOrders) {
			if (tableOrder.isEqualTable(table)) {
				tableOrder.add(order);
				return;
			}
		}
		throw new IllegalArgumentException("해당하는 테이블이 존재하지 않습니다.");
	}
}
