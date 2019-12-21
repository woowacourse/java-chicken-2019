package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private final List<Order> orders = new ArrayList<>();
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	public boolean hasNotOrder() {
		return orders.isEmpty();
	}
}
