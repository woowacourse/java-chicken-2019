import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
	private static final int ORDER_REGISTERATION = 1;

    // TODO 구현 진행
    public static void main(String[] args) {
    	final int functionNumber = Pos.getFunctionNumber();
		if (functionNumber == ORDER_REGISTERATION) {
			final List<Table> tables = TableRepository.tables();
			OutputView.printTables(tables);

			final int tableNumber = InputView.inputTableNumber();

			final List<Menu> menus = MenuRepository.menus();
			OutputView.printMenus(menus);
		}
    }
}
