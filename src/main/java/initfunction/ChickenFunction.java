package initfunction;

import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.Table;
import domain.TableOrder;
import domain.TableRepository;
import domain.TotalOrders;
import view.OutputView;

public abstract class ChickenFunction {
	private final List<Table> tables = TableRepository.tables();
	private final List<Menu> menus = MenuRepository.menus();
	private final TotalOrders totalOrders = new TotalOrders();

	public abstract void run();

	protected TableOrder getTableOrderByTable(Table table) {
		return totalOrders.getTableOrderByTable(table);
	}

	protected void addOrderToTotalOrder(Table table, Order order) {
		totalOrders.addOrder(table, order);
	}

	protected void printAllTable() {
		OutputView.printTables(tables);
	}

	protected void printAllMenus() {
		OutputView.printMenus(menus);
	}
}
