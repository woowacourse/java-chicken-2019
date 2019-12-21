package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private final int chickenDiscountCriteria = 10;
	private final int chickenDiscountPrice = 10000;
	private final double cashDiscountRate = 0.05;
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
	
	public String toAllPrice(final PaymentOption paymentOption) {
		double allPrice = 0;
		
		for (Order order : orderList) {
			allPrice += order.toOrderPrice();
		}
		
		allPrice = applyChickenDiscount(allPrice);
		allPrice = applyCashDiscount(allPrice, paymentOption);
		return allPrice + "원";
	}
	
	public double applyChickenDiscount(final double allPrice) {
		int discountCount = toChickenCount()/chickenDiscountCriteria;
		
		return allPrice - (discountCount * chickenDiscountPrice);
	}
	
	public int toChickenCount() {
		return (int) orderList.stream()
						.filter(order -> order.toMenu().toCategory().isChicken())
						.count();
		
	}
	
	public double applyCashDiscount(final double allPrice, final PaymentOption paymentOption) {
		if (paymentOption.isCash()) {
			return (allPrice - (allPrice * cashDiscountRate));
		}
		return allPrice;
	}
	
	public void removeOrders() {
		orderList.clear();
	}
}
