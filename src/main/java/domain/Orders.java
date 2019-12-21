package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private static final int MAX_ORDER_COUNT = 99;

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

	public Cost getAllCost() {
		Cost cost = Cost.ZERO;
		for (Order order : orders) {
			cost = cost.add(order.getCost());
		}
		return cost;
	}

	public boolean isAbleToOrderMenu(Menu menu, int additionalQuantity) {
		int alreadyOrderedMenuCount = calculateAlreadyOrderedMenuCount(menu);
		return alreadyOrderedMenuCount + additionalQuantity <= MAX_ORDER_COUNT;
	}

	private int calculateAlreadyOrderedMenuCount(Menu menu) {
		return orders.stream()
			.filter(order -> order.isEqualMenu(menu))
			.mapToInt(Order::getQuantity)
			.sum();
	}

	public int getCountOfChickenOrder() {
		// order 각각 메뉴 , 수량 함휴 하고 있다.
		// order 한테 니가 갖고 있는 메뉴 치킨이냐 묻고 필터
		// 걔네들의 갯수
		return orders.stream()
			.filter(order -> order.isChicken())
			.mapToInt(Order::getQuantity)
			.sum();
	}
}
