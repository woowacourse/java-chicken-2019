package controller;

import static domain.Order.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import domain.Menu;
import domain.Order;
import domain.PaymentType;
import domain.PosMenuType;
import domain.Table;
import view.InputView;
import view.OutputView;

/**
 * 프로그램의 전반적인 흐름을 담당하는 객체
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-21
 */
public class ChickenPos {
	private static final int EMPTY_TABLE = 0;
	private static final int DISCOUNT_chicken_COUNT = 10;
	private static final int DISCOUNT_chicken_PRICE = 10_000;
	private static final int PURCHASE_NOT_DECIDED = -1;

	private final List<Table> tables;
	private final List<Menu> menus;
	private final Map<Table, List<Order>> tableOrders;

	public ChickenPos(final List<Table> tables, final List<Menu> menus) {
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
		if (!hasUnpaidTable()) {
			OutputView.printNotHasUnpaidTable();
			return;
		}
		Table table = getNotPaidTable();
		List<Order> orders = findOrders(table);
		OutputView.printOrders(orders);
		int price = calculatePaymentPrice(orders, table);
		OutputView.printPaymentPrice(price);
		orders.clear();
	}

	private boolean hasUnpaidTable() {
		return tableOrders.values()
				.stream()
				.anyMatch(orders -> orders.size() != 0);
	}

	private Table getTable() {
		OutputView.printTables(tables, tableOrders);
		Table table = null;
		while (table == null) {
			int tableNumber = InputView.inputTableNumber();
			table = findTableByTableNumber(tableNumber);
		}
		return table;
	}

	private List<Order> findOrders(Table table) {
		return tableOrders.get(table);
	}

	private Table getNotPaidTable() {
		OutputView.printTables(tables, tableOrders);
		Table table = null;
		while (table == null || isEmptyTable(table)) {
			int tableNumber = InputView.inputTableNumber();
			table = findTableByTableNumber(tableNumber);
		}
		return table;
	}

	private boolean isEmptyTable(Table table) {
		return tableOrders.get(table).size() == EMPTY_TABLE;
	}

	private Table findTableByTableNumber(int tableNumber) {
		return tableOrders.keySet()
				.stream()
				.filter(table -> table.isSameTable(tableNumber))
				.findFirst()
				.orElse(null);
	}

	private int calculatePaymentPrice(List<Order> orders, Table table) {
		int fullPrice = calculateFullPrice(orders);
		int chickenDiscountedPrice = calculateChickenDiscountedPrice(fullPrice, orders);
		PaymentType paymentType = InputView.inputPaymentType(table);
		return calculateCashDiscountedPrice(paymentType, chickenDiscountedPrice);
	}

	private int calculateFullPrice(List<Order> orders) {
		return orders.stream()
				.mapToInt(Order::calculateTotalPrice)
				.sum();
	}

	private int calculateChickenDiscountedPrice(int price, List<Order> orders) {
		int chickenCount = calculateChickenCount(orders);
		return price - chickenCount / DISCOUNT_chicken_COUNT * DISCOUNT_chicken_PRICE;
	}

	private int calculateChickenCount(List<Order> orders) {
		return orders.stream()
				.filter(Order::isChicken)
				.mapToInt(Order::getOrderCount)
				.sum();
	}

	private int calculateCashDiscountedPrice(PaymentType paymentType, int price) {
		return paymentType.calculateDiscountedPrice(price);
	}
}
