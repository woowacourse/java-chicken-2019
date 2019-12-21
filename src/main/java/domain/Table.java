package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table {
	private static final String PAYMENT_ERROR = "주문이 존재하지 않습니다.";

	private final int number;
	private final List<Order> orders = new ArrayList<>();

	public Table(final int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	public boolean isNumber(int number) {
		return this.number == number;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public List<Order> orders() {
		return Collections.unmodifiableList(orders);
	}

	public boolean hasOrder() {
		return !orders.isEmpty();
	}

	public int getNumber() {
		return number;
	}

	public Receipt payment(PaymentType paymentType) {
		if (!hasOrder()) {
			throw new IllegalStateException(PAYMENT_ERROR);
		}
		int price = orders.stream().mapToInt(Order::realPrice).sum();
		orders.clear();
		return new Receipt(price, paymentType);
	}
}
