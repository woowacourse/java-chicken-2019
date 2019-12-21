package domain;

import java.util.ArrayList;
import java.util.List;

import view.InputView;

public class OrderStorage {
	private List<Order> orders = new ArrayList<Order>();
	
	public void enterNewOrder() {
		try {
			int menuNum = InputView.enterNumOfMenu();
			int amount = InputView.enterAmountOfMenu();
			if (isAlreadyExist(menuNum)) {
				addAmount(menuNum, amount);
			}
			if (!isAlreadyExist(menuNum)) {
				addNewOrder(menuNum, amount);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			enterNewOrder();
		}
	}

	private boolean isAlreadyExist(int numOfMenu) {
		return orders.stream()
			.anyMatch(order -> order.isSameMenu(numOfMenu));
	}
	
	private void addNewOrder(int menuNum, int amount) {
		Order newOrder = new Order(menuNum, amount);
		orders.add(newOrder);
	}
	
	private void addAmount(int menuNum, int amount) {
		orders.stream()
			.filter(order -> order.isSameMenu(menuNum))
			.forEach(order -> order.addAmount(amount));
	}
	
	//테스트용
	public void showOrders() {
		for(Order order:orders) {
			System.out.println("메뉴번호: " + order.getNum() + "양: " + order.getAmount());
		}
	}
}
