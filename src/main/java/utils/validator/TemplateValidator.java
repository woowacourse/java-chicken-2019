package utils.validator;

import utils.Constants;

public class TemplateValidator {
	private final String name;

	public TemplateValidator(String name) {
		this.name = name;
		validate();
	}

	private void validate() {
		isRightString();
	}

	private void isRightString() {
		if (!Constants.PATTERN.matcher(name).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_NUMBER_PATTERN);
		}
	}
}
