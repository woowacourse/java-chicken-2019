package utils.validator;

import java.util.Arrays;

import domain.repository.TableRepository;
import utils.Constants;
import utils.Converter;

public class TableNumberValidator {
	protected final String tableNumber;

	public TableNumberValidator(String tableNumber) {
		this.tableNumber = tableNumber;
		validate();
	}

	protected void validate() {
		isRightString();
	}

	protected void isRightString() {
		if (Arrays.stream(TableRepository.TABLE_NUMS).noneMatch(num -> num == Converter.getInt(tableNumber))) {
			throw new IllegalArgumentException(Constants.ERROR_TABLE_NUMBER_PATTERN);
		}
	}
}
