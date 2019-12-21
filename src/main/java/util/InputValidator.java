package util;

import domain.TableRepository;

public class InputValidator {
	public static boolean isValidTableNumber(int tableNumber) {
		return TableRepository.tables().stream()
			.anyMatch(table -> table.isNumberEquals(tableNumber));
	}
}
