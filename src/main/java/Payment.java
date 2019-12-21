import java.util.List;

import domain.PaymentOption;
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
		PaymentOption paymentOption = InputView.inputPaymentOption();
	}
}
