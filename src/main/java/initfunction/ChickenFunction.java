package initfunction;

import java.util.List;

import domain.food.Menu;
import domain.food.MenuRepository;
import domain.order.Order;
import domain.food.Table;
import domain.order.TableOrder;
import domain.food.TableRepository;
import domain.order.TotalOrders;
import view.OutputView;

public abstract class ChickenFunction {
	private static final List<Table> TABLES = TableRepository.tables();
	private static final List<Menu> MENUS = MenuRepository.menus();
	private static final TotalOrders TOTAL_ORDERS = new TotalOrders();

	public abstract void run();

	protected TableOrder getTableOrderByTable(Table table) {
		return TOTAL_ORDERS.getTableOrderByTable(table);
	}

	protected void addOrderToTotalOrder(Table table, Order order) {
		TOTAL_ORDERS.addOrder(table, order);
	}

	protected void printAllTable() {
		OutputView.printTables(TABLES);
	}

	protected void printAllMenus() {
		OutputView.printMenus(MENUS);
	}
}
