package domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import domain.Table;
import domain.User;

public class TableRepository {
	private static final List<Table> tables = new ArrayList<>();
	public static final LinkedHashMap<Integer, User> tableStates = new LinkedHashMap<>();

	static {
		tables.add(new Table(1));
		tables.add(new Table(2));
		tables.add(new Table(3));
		tables.add(new Table(5));
		tables.add(new Table(6));
		tables.add(new Table(8));
	}

	public static final int[] TABLE_NUMS = tables.stream().mapToInt(Table::getNumber).toArray();

	public static List<Table> tables() {
		return Collections.unmodifiableList(tables);
	}

	public static boolean isUserEmpty(int tableNum) {
		return !tableStates.containsKey(tableNum);
	}

	public static void initiateTableUser(int tableNum, User user) {
		tableStates.put(tableNum, user);
	}

	public static void deleteTableState(int tableNum) {
		tableStates.remove(tableNum);
	}

	public static User getUser(int tableNum) {
		return tableStates.get(tableNum);
	}

	@Override
	public String toString() {
		return "테이블 넘버 " + TableRepository.tableStates.toString()
			.substring(1, TableRepository.tableStates.toString().length() - 1);
	}
}

