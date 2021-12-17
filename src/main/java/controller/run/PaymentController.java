package controller.run;

import java.util.Arrays;

import controller.view.InputController;
import domain.repository.TableRepository;
import view.OutputView;

public class PaymentController {
	public void run() {
		if (Arrays.stream(TableRepository.TABLE_NUMS).allMatch(TableRepository::isUserEmpty)) {
			OutputView.printError("결제 가능한 테이블이 없다.");
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
		if (payNumber == 1) {
			OutputView.printPayMoney(CalculateController.getDiscountPay(tableNumber));
		}
		if (payNumber == 2) {
			OutputView.printPayMoney(CalculateController.getCashPay(tableNumber));
		}
	}
}
