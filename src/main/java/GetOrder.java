import java.util.List;

import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class GetOrder {
	final List<Table> tables = TableRepository.tables();
	
	public void run() {
		selectTable();
		OutputView.printMenus(MenuRepository.menus());
	}
	
	public void selectTable() {
		int number = InputView.inputTableNumber();
	}
}
