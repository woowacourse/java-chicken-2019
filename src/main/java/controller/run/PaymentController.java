package controller.run;

import controller.view.InputController;
import domain.repository.TableRepository;
import domain.repository.TableStateRepository;
import view.OutputView;

public class PaymentController {
	public void run() {
		int tableNumber = getPayTableNumber();
		OutputView.printTableMenus(tableNumber);
		printPay(tableNumber, InputController.getPayNumber());
		TableStateRepository.deleteTableState(tableNumber);
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
