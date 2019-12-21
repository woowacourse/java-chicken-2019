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
		}
	}

	private void registerOrder() {
		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);
		final int tableNumber = InputView.inputTableNumber();
		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);
		final int menuNumber = InputView.inputMenuNumber();
		MenuAmount menuAmount = new MenuAmount(InputView.inputMenuAmount());
		Order order = new Order(tableNumber, menuNumber, menuAmount);
		orders.add(order);
	}
}
