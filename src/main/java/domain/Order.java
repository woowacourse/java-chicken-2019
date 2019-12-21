package domain;

import java.util.Objects;

/**
 * 주문 하나를 의미하는 객체
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-21
 */
public class Order {
	public static final int MIN_PURCHASE_COUNT = 1;
	public static final int MAX_PURCHASE_COUNT = 99;

	private final Menu menu;
	private final int orderCount;

	public Order(Menu menu, int orderCount) {
		this.menu = Objects.requireNonNull(menu);
		this.orderCount = orderCount;
	}

	public boolean isChickin() {
		return menu.isChickin();
	}

	public boolean canAddOrder(int totalOrderCount) {
		int sumOfOrderCount = orderCount + totalOrderCount;
		return sumOfOrderCount >= MIN_PURCHASE_COUNT && sumOfOrderCount <= MAX_PURCHASE_COUNT;
	}

	public int getOrderCount() {
		return orderCount;
	}
}
