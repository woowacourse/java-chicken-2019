package domain.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.purchase.Cost;
import domain.food.Menu;

public class Orders {
	private static final int MAX_ORDER_COUNT = 99;

	private final List<Order> orders = new ArrayList<>();

	public void add(Order order) {
		orders.add(order);
	}

	public void removeAll() {
		for (int i = orders.size() - 1; i >= 0; i--) {
			orders.remove(i);
		}
	}

	public Cost getAllCost() {
		Cost cost = Cost.ZERO;
		for (Order order : orders) {
			cost = cost.add(order.getCost());
		}
		return cost;
	}

	public boolean isAbleToOrderMenu(Menu menu, int additionalQuantity) {
		int alreadyOrderedMenuCount = calculateAlreadyOrderedMenuCount(menu);
		return alreadyOrderedMenuCount + additionalQuantity <= MAX_ORDER_COUNT;
	}

	private int calculateAlreadyOrderedMenuCount(Menu menu) {
		return orders.stream()
			.filter(order -> order.isEqualMenu(menu))
			.mapToInt(Order::getQuantity)
			.sum();
	}

	public int getCountOfChickenOrder() {
		return orders.stream()
			.filter(order -> order.isChicken())
			.mapToInt(Order::getQuantity)
			.sum();
	}

	@Override
	public String toString() {
		return orders.stream()
			.map(Order::toString)
			.collect(Collectors.joining("\n"));
	}
}
