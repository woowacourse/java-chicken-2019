package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private final List<Order> orderList = new ArrayList<>();
	
	public void addOrder(Order order) {
		orderList.add(order);
	}
	
	public boolean hasNotOrder() {
		return orderList.isEmpty();
	}
	
	public List<Order> toList() {
		return orderList;
	}
	
	public String toAllPrice() {
		int allPrice = 0;
		
		for (Order order : orderList) {
			allPrice += order.toOrderPrice();
		}
		
		return allPrice + "원";
	}
}
