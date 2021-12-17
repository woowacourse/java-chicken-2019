package utils.validator;

import java.util.Arrays;

import domain.repository.MenuRepository;
import utils.Constants;
import utils.Converter;

public class MenuNumberValidator {
	private final String menuNumber;

	public MenuNumberValidator(String menuNumber) {
		this.menuNumber = menuNumber;
		validate();
	}

	private void validate() {
		isRightString();
	}

	private void isRightString() {
		if (Arrays.stream(MenuRepository.MENU_NUMS).noneMatch(num -> num == Converter.getInt(menuNumber))) {
			throw new IllegalArgumentException(Constants.ERROR_MENU_NUMBER_PATTERN);
		}
	}
}
