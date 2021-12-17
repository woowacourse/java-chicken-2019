package domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Menu;
import domain.Table;

public class TableRepository {
	private static final List<Table> tables = new ArrayList<>();

	static {
		tables.add(new Table(1));
		tables.add(new Table(2));
		tables.add(new Table(3));
		tables.add(new Table(5));
		tables.add(new Table(6));
		tables.add(new Table(8));
	}

	public static List<Table> tables() {
		return Collections.unmodifiableList(tables);
	}

	public static Table getTableByNum(int num) {
		return tables.stream().filter(table -> table.getNumber() == num)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당 숫자의 테이블이 없습니다."));
	}

	public static final int[] TABLE_NUMS = tables.stream().mapToInt(Table::getNumber).toArray();
}

