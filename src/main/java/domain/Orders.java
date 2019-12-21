package domain;

import java.util.List;

public class Orders {
	private final List<Order> orders;

	public Orders(List<Order> orders) {
		this.orders = orders;
	}

	public void add(Order order) {
		orders.add(order);
	}

}
