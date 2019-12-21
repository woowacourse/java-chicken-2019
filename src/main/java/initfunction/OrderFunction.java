package initfunction;

import domain.Order;
import domain.Table;
import domain.TableOrder;
import view.InputView;

public class OrderFunction extends ChickenFunction {
	@Override
	public void run() {
		printAllTable();
		Table table = InputView.inputTable();

		printAllMenus();
		TableOrder tableOrder = getTableOrderByTable(table);
		System.out.println(tableOrder + " ");
		Order order = InputView.inputOrderIn(tableOrder);
		addOrderToTotalOrder(table, order);

		InputView.inputFunction().run();
	}
}
