package domain;

import exceptions.OutOfNumberException;

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

	public static Boolean isIntInTables(Integer target) throws OutOfNumberException {
		Boolean itsInTable = false;

		for (Table table : tables) {
			itsInTable = table.isItInt(target);
			return itsInTable;
		}
		if (itsInTable.equals(false)) {
			throw new OutOfNumberException();
		}
		return itsInTable;
	}

	public Boolean addOrder(Integer tableNumber, Menu menu) {
		Integer index = 0;

		for (Table table : this.tables) {
			if (table.isItInt(index++).equals(tableNumber)) {
				table.setOrder(menu);
				return true;
			}
		}
		return false;
	}
}