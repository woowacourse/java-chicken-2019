package utils.validator;

import domain.repository.TableStateRepository;
import utils.Constants;
import utils.Converter;

public class TablePayNumberValidator extends TableNumberValidator {
	public TablePayNumberValidator(String tableNumberString) {
		super(tableNumberString);
	}

	@Override
	protected void validate() {
		isRightString();
		isIn();
	}

	protected void isIn() {
		if (TableStateRepository.isUserEmpty(Converter.getInt(tableNumber))) {
			throw new IllegalArgumentException(Constants.TABLE_IS_NOT_IN);
		}
	}
}
