import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class GetOrder {
	final List<Table> tables = TableRepository.tables();
	
	public void run() {
		Table table = InputView.inputTableNumber();
		OutputView.printMenus(MenuRepository.menus());
		Menu menu = InputView.inputMenuNumber();
	}
}
