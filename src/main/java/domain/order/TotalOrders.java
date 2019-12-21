package domain.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.food.Table;
import domain.food.TableRepository;

public class TotalOrders {
	private final List<TableOrder> totalOrders = new ArrayList<>();

	public TotalOrders() {
		List<Table> tables = TableRepository.tables();
		for (Table table : tables) {
			totalOrders.add(new TableOrder(table));
		}
	}

	public void addOrder(Table table, Order order) {
		TableOrder tableOrder = getTableOrderByTable(table);
		System.out.println(tableOrder);
		tableOrder.add(order);
	}

	public TableOrder getTableOrderByTable(Table table) {
		for (TableOrder tableOrder : totalOrders) {
			if (tableOrder.isEqualTable(table)) {
				return tableOrder;
			}
		}
		throw new IllegalArgumentException("해당하는 테이블이 존재하지 않습니다.");
	}

	@Override
	public String toString() {
		return totalOrders.stream()
			.map(TableOrder::toString)
			.collect(Collectors.joining("\n"));
	}
}
