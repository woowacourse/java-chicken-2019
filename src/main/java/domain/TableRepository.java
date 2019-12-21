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

	public static void addMenu(int tableNumber, int menuNumber, int menuCount) throws Exception {
		for (Table table : tables) {
			if (table.getNumber() == tableNumber) {
				table.addMenu(menuNumber, menuCount);
				return;
			}
		}
		throw new Exception("해당 테이블이 존재하지 않습니다.");
	}

	public static Table getTable(int tableNumber) {
		for (Table table : tables) {
			if (table.getNumber() == tableNumber) {
				return table;
			}
		}
		return null;
	}
}
