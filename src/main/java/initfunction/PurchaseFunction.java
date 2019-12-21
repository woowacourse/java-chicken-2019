package initfunction;

import domain.Payment;
import domain.Purchase;
import domain.Table;
import domain.TableOrder;
import view.InputView;

public class PurchaseFunction extends ChickenFunction {
	@Override
	public void run() {
		printAllTable();
		Table table = InputView.inputTable();

		TableOrder tableOrder = getTableOrderByTable(table);
		Payment howToPay = InputView.inputPayment();
		Purchase purchase = new Purchase(tableOrder, howToPay);
		purchase.calculate();
	}
}
