package domain;

import java.util.List;

public class Orders {
	private static final String CATEGORY_NAME_OF_CHICKEN = "[치킨]";
	private static int DISCOUNT_BOUNDARY = 10;
	private static int DISCOUNT_AMOUNT_OF_CHICKEN = 10000;

	private final List<Order> orders;

	public Orders(List<Order> orders) {
		this.orders = orders;
	}

	public void add(Order order) {
		orders.add(order);
	}

	public boolean isOrderIn(int tableNumber) {
		return orders.stream().anyMatch(order -> order.isTableEquals(tableNumber));
	}

	public String getMenuAccounts(int tableNumber) {
		return orders.stream()
			.filter(order -> order.isTableEquals(tableNumber))
			.findFirst()
			.map(Order::menuAccounts)
			.orElse(null);
	}

	public int getTotalPrice(int tableNumber) {
		int totalPrice = 0;
		int chickenCount = 0;
		for (Order order : orders) {
			if (order.isTableEquals(tableNumber)) {
				totalPrice += order.getPrice();
			}
			if (order.isCategoryEquals(CATEGORY_NAME_OF_CHICKEN)) {
				chickenCount++;
			}
		}
		if (chickenCount >= DISCOUNT_BOUNDARY) {
			int discountTimes = chickenCount / DISCOUNT_BOUNDARY;
			totalPrice -= DISCOUNT_AMOUNT_OF_CHICKEN * discountTimes;
		}
		return totalPrice;
	}

	public void deleteOrder(int tableNumber) {
		orders.removeIf(order -> order.isTableEquals(tableNumber));
	}

	public boolean isEmpty() {
		return orders.isEmpty();
	}
}
