package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private final List<Order> orders = new ArrayList<>();

	public void add(Order order) {
		orders.add(order);
	}
}
