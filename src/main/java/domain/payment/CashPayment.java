package domain.payment;

import domain.purchase.Cost;

public class CashPayment implements Payment {
	private static final int CASH_DISCOUNT_RATE = 5;

	@Override
	public Cost getCostByPaymentMethod(Cost costs) {
		System.out.println("현금 결제");
		return costs.getDisCountedPrice(CASH_DISCOUNT_RATE);
	}
}
