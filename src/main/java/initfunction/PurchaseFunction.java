package initfunction;

import domain.payment.Payment;
import domain.purchase.Purchase;
import domain.food.Table;
import domain.order.TableOrder;
import view.InputView;
import view.OutputView;

public class PurchaseFunction extends ChickenFunction {
	@Override
	public void run() {
		printAllTable();
		Table table = InputView.inputTable();

		TableOrder tableOrder = getTableOrderByTable(table);
		OutputView.printTableOrderToPay(tableOrder);
		Payment howToPay = InputView.inputPayment();
		Purchase purchase = new Purchase(tableOrder, howToPay);
		purchase.calculate();

		InputView.inputFunction().run();
	}
}
