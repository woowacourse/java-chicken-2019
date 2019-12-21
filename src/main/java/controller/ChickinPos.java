package controller;

import static domain.Order.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import domain.Menu;
import domain.Order;
import domain.PosMenuType;
import domain.Table;
import view.InputView;
import view.OutputView;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-21
 */
public class ChickinPos {
	private static final int PURCHASE_NOT_DECIDED = -1;

	private final List<Table> tables;
	private final List<Menu> menus;
	private final Map<Table, List<Order>> tableOrders;

	public ChickinPos(final List<Table> tables, final List<Menu> menus) {
		this.tables = tables;
		this.menus = Objects.requireNonNull(menus);
		this.tableOrders = initializeOrdersByTable(tables);
	}

	private Map<Table, List<Order>> initializeOrdersByTable(List<Table> tables) {
		return tables.stream()
				.collect(Collectors.toMap(
						table -> table,
						number -> new ArrayList<>()
				));
	}

	public void run() {
		PosMenuType posMenu = PosMenuType.START;
		while (!PosMenuType.END_PROGRAM.equals(posMenu)) {
			posMenu = InputView.inputPosMenu();
			runPosFeature(posMenu);
		}
		OutputView.printEndPos();
	}

	private void runPosFeature(PosMenuType menu) {
		if (PosMenuType.ADD_ORDER.equals(menu)) {
			addOrder();
		}
		if (PosMenuType.PAYMENT.equals(menu)) {
			payment();
		}
	}

	private void addOrder() {
		OutputView.printTables(tables, tableOrders);
		Table table = getTable();
		Order order = getOrder();
		if (!canAddOrder(table, order)) {
			OutputView.printOrderCountExceed();
			return;
		}
		tableOrders.get(table).add(order);
	}

	private Order getOrder() {
		OutputView.printMenus(menus);
		Menu menu = getMenu();
		int purchaseCount = getPurchaseCount();
		return new Order(menu, purchaseCount);
	}

	private Table getTable() {
		Table table = null;
		while (table == null) {
			int tableNumber = InputView.inputTableNumber();
			table = findTableByTableNumber(tableNumber);
		}
		return table;
	}

	private Table findTableByTableNumber(int tableNumber) {
		return tableOrders.keySet()
				.stream()
				.filter(table -> table.isSameTable(tableNumber))
				.findFirst()
				.orElse(null);
	}

	private Menu getMenu() {
		Menu menu = null;
		while (menu == null) {
			int menuNumber = InputView.inputMenuNumber();
			menu = findMenuByMenuNumber(menuNumber);
		}
		return menu;
	}

	private Menu findMenuByMenuNumber(int menuNumber) {
		return menus.stream()
				.filter(it -> it.isSameNumber(menuNumber))
				.findFirst()
				.orElse(null);
	}

	private int getPurchaseCount() {
		int number = PURCHASE_NOT_DECIDED;
		while (number < MIN_PURCHASE_COUNT || number > MAX_PURCHASE_COUNT) {
			number = InputView.inputPurchaseCount();
		}
		return number;
	}

	private boolean canAddOrder(Table table, Order order) {
		int tableNumber = table.getNumber();
		List<Order> orders = findOrderByTableNumber(tableNumber);
		int totalOrderCount = calculateTotalOrderCount(table);
		return order.canAddOrder(totalOrderCount);
	}

	private List<Order> findOrderByTableNumber(int tableNumber) {
		return tableOrders.get(tableNumber);
	}

	private int calculateTotalOrderCount(Table table) {
		return tableOrders.get(table)
				.stream()
				.mapToInt(Order::getOrderCount)
				.sum();
	}

	private void payment() {

	}
}
