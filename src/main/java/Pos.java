import java.util.ArrayList;
import java.util.List;

import domain.Menu;
import domain.MenuAmount;
import domain.MenuRepository;
import domain.Order;
import domain.Orders;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class Pos {
	private static final int ORDER_REGISTER_NUMBER = 1;
	private static final int PAYMENT_NUMBER = 2;

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
			int payAmount = getPayAmount(InputView.inputTableNumber());
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

	private int getPayAmount(int tableNumber) {
		OutputView.printMenuAccounts(tableNumber, orders);
		return 0;
	}
}
