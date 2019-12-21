package initfunction;

import domain.order.Order;
import domain.food.Table;
import domain.order.TableOrder;
import view.InputView;

public class OrderFunction extends ChickenFunction {
	@Override
	public void run() {
		printAllTable();
		Table table = InputView.inputTable();

		printAllMenus();
		TableOrder tableOrder = getTableOrderByTable(table);
		Order order = InputView.inputOrderIn(tableOrder);
		addOrderToTotalOrder(table, order);

		InputView.inputFunction().run();
	}
}
