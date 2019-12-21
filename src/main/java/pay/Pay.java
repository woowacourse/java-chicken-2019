package pay;

import java.util.List;
import java.util.stream.Collectors;

import domain.OrderMenu;
import view.InputView;

public class Pay {
	private static final double CASH_DISCOUNT = 0.98;
	private static final int CHICKEN_DISCOUNT = 10000;
	private static final double CREDIT_CARD = 1;
	private static final double CASH = 2;

	public static void pay(List<OrderMenu> orderMenuList, int tableNumber) {
		printOrderList(orderMenuList);
		printTableNumber(tableNumber);
		// int chickenDiscountMoney = discountMoneyChickenMoreThanTen(orderMenuList);
		int paymentType = InputView.inputPaymentType();
		int payMoney = getTotalMoneyToPay(orderMenuList);
		printPaymentResult(paymentType, payMoney);
	}

	private static double getPayment(int paymentType, int payMoney) {
		double payment = 0;

		if (paymentType == CREDIT_CARD) {
			payment = payMoney;
		}
		if (paymentType == CASH) {
			payment = payMoney * CASH_DISCOUNT;
		}
		if (payment < 0) {
			return 0;
		}
		return payment;
	}

	// private static int discountMoneyChickenMoreThanTen(List<OrderMenu> orderMenuList) {
	// 	int totalChickenNumber = getNumberOfChicken(orderMenuList);
	// 	int discountNumber = totalChickenNumber / 10;
	// 	System.out.println("치킨 개수" + totalChickenNumber);
	// 	System.out.println("할인 받을 개수" + discountNumber);
	// 	if (discountNumber > 0) {
	// 		System.out.println("할인 받을 금액" + CHICKEN_DISCOUNT * discountNumber);
	// 		return CHICKEN_DISCOUNT * discountNumber;
	// 	}
	// 	return 0;
	// }

	// private static void getNumberOfChicken(List<OrderMenu> orderMenuList) {
	// 	return orderMenuList.stream()
	// 		.filter(orderMenu -> orderMenu.isChicken())
	// 		.map(orderMenu -> orderMenu.getNumber())
	// }

	private static int getTotalMoneyToPay(List<OrderMenu> orderMenuList) {
		return orderMenuList.stream().map(orderMenu -> orderMenu.getTotalPrice()).reduce(Integer::sum).get();
	}

	private static void printOrderList(List<OrderMenu> orderMenuList) {
		System.out.println("## 주문 내역");
		System.out.println("메뉴 수량 금액");
		for (OrderMenu orderMenu : orderMenuList) {
			System.out.println(orderMenu);
		}
	}

	private static void printTableNumber(int tableNumber) {
		System.out.println(tableNumber + "번 테이블의 결제를 진행합니다.");
	}

	private static void printPaymentResult(int paymentType, int payMoney) {
		double payment = getPayment(paymentType, payMoney);
		System.out.println("최종 결제한 금액은 " + (int)payment + "원 입니다.");
	}

}
