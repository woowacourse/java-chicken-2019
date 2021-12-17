package controller.view;

import domain.Table;
import utils.Converter;
import utils.validator.MainNumberValidator;
import utils.validator.MenuCountValidator;
import utils.validator.MenuNumberValidator;
import utils.validator.TableNumberValidator;
import view.InputView;
import view.OutputView;

public class InputController {
	public static int getMainNumber() {
		try {
			String numString = InputView.inputMainNumber();
			new MainNumberValidator(numString);
			return Converter.getInt(numString);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMainNumber();
		}
	}

	public static int getTableNumber() {
		try {
			String numString = InputView.inputTableNumber();
			new TableNumberValidator(numString);
			return Converter.getInt(numString);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getTableNumber();
		}
	}

	public static int getMenuNumber() {
		try {
			String numString = InputView.inputMenuNumber();
			new MenuNumberValidator(numString);
			return Converter.getInt(numString);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMenuNumber();
		}
	}

	public static int getMenuCount() {
		try {
			String numString = InputView.inputMenuCountNumber();
			new MenuCountValidator(numString);
			return Converter.getInt(numString);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMenuCount();
		}
	}
}
