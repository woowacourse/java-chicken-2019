package utils.validator;

import utils.Constants;
import utils.Converter;

public class MenuCountValidator {
	private final String countString;

	public MenuCountValidator(String countString) {
		this.countString = countString;
		validate();
	}

	public MenuCountValidator(int count) {
		this.countString = Converter.getString(count);
		validate();
	}

	private void validate() {
		isRightString();
	}

	private void isRightString() {
		if (!Constants.PATTERN_COUNT_NUM.matcher(countString).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_MENU_COUNT_PATTERN);
		}
	}
}
