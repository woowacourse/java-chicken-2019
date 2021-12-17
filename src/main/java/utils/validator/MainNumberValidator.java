package utils.validator;

import utils.Constants;

public class MainNumberValidator {
	private final String numberString;

	public MainNumberValidator(String numberString) {
		this.numberString = numberString;
		validate();
	}

	private void validate() {
		isRightString();
	}

	private void isRightString() {
		if (!Constants.PATTERN_MAIN_NUM.matcher(numberString).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_MAIN_NUMBER_PATTERN);
		}
	}
}
