package controller.run;

import java.util.Arrays;

import controller.view.InputController;
import domain.repository.TableRepository;
import utils.Constants;
import view.OutputView;

public class PaymentController {
	public void run() {
		if (Arrays.stream(TableRepository.TABLE_NUMS).allMatch(TableRepository::isUserEmpty)) {
			OutputView.printError(Constants.ERROR_NO_USER);
			return;
		}
		int tableNumber = getPayTableNumber();
		OutputView.printTableMenus(tableNumber);
		printPay(tableNumber, InputController.getPayNumber());
		TableRepository.deleteTableState(tableNumber);
	}

	private int getPayTableNumber() {
		OutputView.printTables(TableRepository.tables());
		return InputController.getPayTableNumber();
	}

	private void printPay(int tableNumber, int payNumber) {
		if (payNumber == Constants.PAY_CARD) {
			OutputView.printPayMoney(CalculateController.getDiscountPay(tableNumber));
		}
		if (payNumber == Constants.PAY_CASH) {
			OutputView.printPayMoney(CalculateController.getCashPay(tableNumber));
		}
	}
}
