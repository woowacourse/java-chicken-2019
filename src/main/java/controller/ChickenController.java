package controller;

import java.util.List;

import domain.Amount;
import domain.MainScreen;
import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.PaymentType;
import domain.Receipt;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class ChickenController {
	private boolean isRunning;

	private void mainScreen() {
		MainScreen mainScreen = MainScreen.valueOf(InputView.inputMainScreen());
		if (mainScreen.isOrder()) {
			order();
			return;
		}
		if (mainScreen.isPayment()) {
			payment();
			return;
		}
		if (mainScreen.isExit()) {
			exit();
		}
	}

	private void order() {
		try {
			final List<Table> tables = TableRepository.tables();
			OutputView.printTables(tables);
			Table table = TableRepository.valueOf(InputView.inputTableNumber());
			final List<Menu> menus = MenuRepository.menus();
			OutputView.printMenus(menus);
			Menu menu = MenuRepository.valueOf(InputView.inputMenuNumber());
			Amount amount = new Amount(InputView.inputMenuAmount());
			Order order = new Order(menu, amount);
			table.addOrder(order);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
		}
	}

	private void payment() {
		try {
			final List<Table> tables = TableRepository.tables();
			OutputView.printTables(tables);
			Table table = TableRepository.valueOf(InputView.inputTableNumber());
			OutputView.printOrders(table.orders());
			PaymentType paymentType = PaymentType.valueOf(InputView.inputPaymentType(table.getNumber()));
			Receipt receipt = table.payment(paymentType);
			OutputView.printPrice(receipt.totalPrice());
		} catch (IllegalArgumentException | IllegalStateException e) {
			OutputView.printError(e.getMessage());
		}
	}

	private void exit() {
		isRunning = false;
	}

	public void run() {
		isRunning = true;
		while (isRunning) {
			mainScreen();
		}
	}
}
