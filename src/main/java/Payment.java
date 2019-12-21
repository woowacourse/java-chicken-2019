import java.util.List;

import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class Payment {
	final List<Table> tables = TableRepository.tables();
	
	public void run() {
		Table table = InputView.inputTableNumber();
		OutputView.printOrderList(table);
		OutputView.printPayingProcess(table);
		OutputView.printAllPrice(table, InputView.inputPaymentOption());
		table.toOrders().removeOrders();
	}
}
