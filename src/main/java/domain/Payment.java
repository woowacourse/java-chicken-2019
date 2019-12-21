package domain;

import java.util.List;
import java.util.stream.Collectors;

import view.InputView;
import view.OutputView;

public class Payment {
	private static final int ONE_MILLION_WON = 10000;
	private static final int CASH = 2;
	private static final double CASH_DISCOUNT = 0.95;
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
		calculateTotalMoney(tables, paymentWay, tableNumber);
		removeOrderList(tables, tableNumber);
	}
	
	private static void calculateTotalMoney(List<Table> tables, int paymentWay, int tableNumber) {
		double totalMoney = 0;
		int chickenCategoryDiscount = 0;
		for (Table table : tables) {
			if (tableNumber == table.getTableNumber()) {
				totalMoney += table.getTotalMoney();
				chickenCategoryDiscount += table.chickenQuantityDiscount() * ONE_MILLION_WON;
			}
		}
		totalMoney -= chickenCategoryDiscount;
		if (paymentWay == CASH) {
			totalMoney *= CASH_DISCOUNT;
		}
		OutputView.printFinalMoney(totalMoney);
	}
	
	private static void removeOrderList(List<Table> tables, int tableNumber) {
		for (Table table : tables) {
			if (tableNumber == table.getTableNumber()) {
				table.removeOrderList();
			}
		}
	}
}
