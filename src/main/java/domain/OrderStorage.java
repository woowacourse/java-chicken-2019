package domain;

import java.util.ArrayList;
import java.util.List;

import view.InputView;

public class OrderStorage {
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int TWO_ONE = 21;
	private static final int TWO_TWO = 22;
	
	private List<Order> orders = new ArrayList<Order>();
	
	public void enterNewOrder() {
		int menuNum = enterNumOfMenu();
		int amount = enterAmount();
		if (!isAlreadyExist(menuNum)) {
			Order newOrder = new Order(menuNum, amount);
			orders.add(newOrder);
		} else {
			orders.stream()
				.filter(order -> order.isSameMenu(menuNum))
				.forEach(order -> order.addAmount(amount));
		}
	}
	
	public int enterNumOfMenu() {
		try {
			int input = InputView.enterNumOfMenu();
			checkValidNumOfMenu(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterNumOfMenu();
		}	
	}
	
	private void checkValidNumOfMenu(int input) {
		if ((input != ONE) && (input != TWO) && (input != THREE) && (input != FOUR)
				&& (input != FIVE) && (input != SIX) && (input != TWO_ONE) && (input != TWO_TWO)) {
			throw new IllegalArgumentException("적절한 메뉴 번호를 입력해주세요");
		}
	}
	
	public int enterAmount() {
		try {
			int input = InputView.enterAmountOfMenu();
			checkValidAmountOfMenu(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterAmount();
		}	
	}
	
	private void checkValidAmountOfMenu(int input) {
		if (input < 1 || input > 99) {
			throw new IllegalArgumentException("1개 이상, 99개 이하를 입력해주세요");
		}
	}
	
	private boolean isAlreadyExist(int numOfMenu) {
		return orders.stream()
			.anyMatch(order -> order.isSameMenu(numOfMenu));
	}
	
	//테스트용
	public void showOrders() {
		for(Order order:orders) {
			System.out.println("메뉴번호: " + order.getNum() + "양: " + order.getAmount());
		}
	}
}
