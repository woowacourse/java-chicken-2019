package domain;

import java.util.List;
import java.util.stream.Collectors;

import view.InputView;
import view.OutputView;

public class Payment {
	private static int paymentWay;
	public static void startPayment(List<Table> tables, List<Menu> menus) {
		if (tables.stream()
				.map(Table::isOrderedTable)
				.filter(num -> num != -1)
				.collect(Collectors.toList()).size() < 1) {
			System.out.println("결제를 진행할 테이블이 없습니다.");
			return;
		}
		final int tableNumber = InputView.inputTableNumber();
		OutputView.printOrderedList(tables, tableNumber, menus);
		paymentWay = InputView.inputPaymentWay(tables, tableNumber);
	}
}
