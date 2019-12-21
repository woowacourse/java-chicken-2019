package domain;

import java.util.ArrayList;
import java.util.List;

import view.InputView;

public class OrderStorage {
	private static final int CHIKEN_DISCOUNT_THRESHOLD = 10;
	private static final int CHIKEN_DISCOUNT_MONEY = 10000;
	
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
	
	public String toString() {
		StringBuilder message = new StringBuilder();
		message.append("메뉴 수량 금액\n");
		orders.stream()
			.forEach(order -> message.append(order.toString() + "\n"));
		return message.toString();
	}
	
	public int calculateFinalPrice(boolean isCache) {
		int price = calculatePrice();
		if (isCache) {
			return (int) ((double) (price * 0.95));
		}
		return price;
	}
	
	private int calculatePrice() {
		return orders.stream()
			.map(order -> MenuRepository.numToPrice(order.getNum()) * order.getAmount())
			.mapToInt(i -> i)
			.sum() - calculateChikenDiscount();
	}
	
	private int calculateChikenDiscount() {
		int chikenAmount = orders.stream()
			.filter(order -> order.isChiken())
			.map(order -> order.getAmount())
			.mapToInt(i -> i)
			.sum();
		return (chikenAmount / CHIKEN_DISCOUNT_THRESHOLD) * CHIKEN_DISCOUNT_MONEY;
	}
	
	//테스트용
	public void showOrders() {
		for(Order order:orders) {
			System.out.println("메뉴번호: " + order.getNum() + "양: " + order.getAmount());
		}
	}
}
