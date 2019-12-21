package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	public static Table getTableByNumber(int tableNumber) {
		for (Table table : tables) {
			if (table.isRightNumber(tableNumber)) {
				return table;
			}
		}
		throw new IllegalArgumentException("유효하지 않는 테이블 번호입니다.");
	}
}
