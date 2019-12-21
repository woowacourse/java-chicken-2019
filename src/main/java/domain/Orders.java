package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private final List<Order> orders = new ArrayList<>();

	public void add(Order order) {
		orders.add(order);
	}

	public void removeAll() {
		for (int i = orders.size() - 1; i >= 0; i--) {
			orders.remove(i);
		}
		System.out.println("<<<<<<<<<<<<<<삭제 되면 사이즈 값 0 나와야해  " + orders.size());
	}
}
