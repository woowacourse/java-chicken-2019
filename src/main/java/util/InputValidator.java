package util;

import domain.MenuRepository;
import domain.TableRepository;

public class InputValidator {
	public static boolean isValidTableNumber(int tableNumber) {
		return TableRepository.tables().stream()
			.anyMatch(table -> table.isNumberEquals(tableNumber));
	}

	public static boolean isValidMenuNumber(int menuNumber) {
		return MenuRepository.menus().stream()
			.anyMatch(menu -> menu.isNumberEquals(menuNumber));
	}
}
