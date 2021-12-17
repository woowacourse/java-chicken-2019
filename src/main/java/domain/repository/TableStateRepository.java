package domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import domain.Table;
import domain.User;

public class TableStateRepository {
	private static final LinkedHashMap<Integer, User> tableStates = new LinkedHashMap<>();

	public static boolean isUserEmpty(int tableNum) {
		return !tableStates.containsKey(tableNum);
	}

	public static void initiateTableUser(int tableNum, User user) {
		tableStates.put(tableNum, user);
	}

	public static User getUser(int tableNum) {
		return tableStates.get(tableNum);
	}

	public static void deleteTableState(int tableNum) {
		tableStates.remove(tableNum);
	}

	public String toString() {
		return "테이블 넘버 " + TableStateRepository.tableStates.toString()
			.substring(1, TableStateRepository.tableStates.toString().length() - 1);
	}
}

