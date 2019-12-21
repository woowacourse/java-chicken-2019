package domain.payment;

import domain.purchase.Cost;

public class CreditPayment implements Payment {
	@Override
	public Cost getCostByPaymentMethod(Cost costs) {
		System.out.println("신용카드 결제");
		return costs;
	}
}
