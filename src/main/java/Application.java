import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;
import Controller.SelectControl;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
	final List<Table> tables = TableRepository.tables();
	final List<Menu> menus = MenuRepository.menus();
	while (true) {
	    OutputView.printMainScreen();
	    final int functionNumber = InputView.inputFuction();
	    OutputView.printTables(tables);
	    final int tableNumber = InputView.inputTableNumber(tables);
	    OutputView.printMenus(menus);
	    int menuNumber = InputView.inputMenu(menus);
	    int menuAmount=InputView.inputMenuAmount(tables.get(tableNumber));
	}

    }
}
