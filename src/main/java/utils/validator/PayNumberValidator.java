package utils.validator;

import utils.Constants;

public class PayNumberValidator {
	private final String numberString;

	public PayNumberValidator(String numberString) {
		this.numberString = numberString;
		validate();
	}

	private void validate() {
		isRightString();
	}

	private void isRightString() {
		if (!Constants.PATTERN_PAY_NUM.matcher(numberString).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_PAY_NUMBER_PATTERN);
		}
	}
}
