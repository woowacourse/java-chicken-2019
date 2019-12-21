import java.util.List;

import domain.Menu;
import domain.MenuAmount;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class Pos {
	private static final int ORDER_REGISTER_NUMBER = 1;

	private final int functionNumber;

	public Pos() {
		this.functionNumber = getFunctionNumber();
	}

	private static int getFunctionNumber() {
		OutputView.printMainScreen();
		return InputView.inputFunctionNumber();
	}

	public void play() {
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
		MenuAmount menuAmount = new MenuAmount(InputView.inputMenuAmount());

	}
}
