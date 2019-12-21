package domain;

import static domain.Order.*;

import java.util.ArrayList;
import java.util.List;

public class Bill {

	private List<Order> orders;

	Bill () {
		this.orders = new ArrayList<>();
	}

	public boolean hasOrder() {
		return orders.size() > ZERO;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}

	public List<Order> getOrders() {
		return orders;
	}
}
