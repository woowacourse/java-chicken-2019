package initfunction;

import domain.Payment;
import domain.Purchase;
import domain.Table;
import domain.TableOrder;
import view.InputView;
import view.OutputView;

public class PurchaseFunction extends ChickenFunction {
	@Override
	public void run() {
		printAllTable();
		Table table = InputView.inputTable();
		System.out.println("테이블 + " + table);

		TableOrder tableOrder = getTableOrderByTable(table);
		System.out.println(tableOrder + "테이블오더 구매");
		OutputView.printTableOrderToPay(tableOrder);
		Payment howToPay = InputView.inputPayment();
		Purchase purchase = new Purchase(tableOrder, howToPay);
		purchase.calculate();

		InputView.inputFunction().run();
	}
}
