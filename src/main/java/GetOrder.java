import java.util.List;

import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class GetOrder {
	final List<Table> tables = TableRepository.tables();
	
	public void run() {
		selectTable();
	}
	
	public void selectTable() {
		Table table;
		
		try {
			OutputView.printTables(tables);
			final int tableNumber = InputView.inputTableNumber();
			table = new Table(tableNumber);
			TableRepository.isExist(table);
		} catch (Exception e) {
			System.out.println(e);
			selectTable();
		}
	}
}
