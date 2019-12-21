import java.util.List;

import domain.Table;
import domain.TableRepository;
import view.InputView;

public class Payment {
	final List<Table> tables = TableRepository.tables();
	
	public void run() {
		Table table = InputView.inputTableNumber();
	}
}
