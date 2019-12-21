import java.util.ArrayList;

import domain.Menu;
import domain.MenuAmount;
import domain.MenuRepository;
import domain.Order;
import domain.Orders;
import domain.Price;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class Pos {
	private static final int ORDER_REGISTER_NUMBER = 1;
	private static final int PAYMENT_NUMBER = 2;
	private static final int CASH = 2;
	private static final double CASH_DISCOUNT_AMOUNT = 0.05;
	private static final double NO_DISCOUNT = 0.0;
	private static final int QUIT_NUMBER = 3;

	private final Orders orders;

	public Pos() {
		orders = new Orders(new ArrayList<>());
	}

	private static int getFunctionNumber() {
		OutputView.printMainScreen();
		return InputView.inputFunctionNumber();
	}

	public void play() {
		int functionNumber = getFunctionNumber();
		if (functionNumber == ORDER_REGISTER_NUMBER) {
			registerOrder();
			return;
		}
		if (functionNumber == PAYMENT_NUMBER) {
			OutputView.printTables(TableRepository.tables(), orders);
			int tableNumber = InputView.inputTableNumber();
			OutputView.printTotalPayment(getPayAmount(tableNumber));
			orders.deleteOrder(tableNumber);
			return;
		}
		if (functionNumber == QUIT_NUMBER) {
			throw new IllegalArgumentException("프로그램 종료");
		}
	}

	private void registerOrder() {
		OutputView.printTables(TableRepository.tables(), orders);
		Table table = new Table(InputView.inputTableNumber());

		OutputView.printMenus(MenuRepository.menus());
		Menu menu = MenuRepository.getMenu(InputView.inputMenuNumber());

		MenuAmount menuAmount = new MenuAmount(InputView.inputMenuAmount());

		Order order = new Order(table, menu, menuAmount);
		orders.add(order);
	}

	private Price getPayAmount(int tableNumber) {
		OutputView.printMenuAccounts(tableNumber, orders);
		int paymentWayNumber = InputView.inputPaymentWayNumber(tableNumber);
		return calculatePaymentPrice(paymentWayNumber, tableNumber);
	}

	private Price calculatePaymentPrice(int paymentWayNumber, int tableNumber) {
		if (paymentWayNumber == CASH) {
			return new Price(orders.getTotalPrice(tableNumber), CASH_DISCOUNT_AMOUNT);
		}
		return new Price(orders.getTotalPrice(tableNumber), NO_DISCOUNT);
	}

}
