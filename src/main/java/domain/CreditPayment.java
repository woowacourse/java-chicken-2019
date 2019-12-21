package domain;

public class CreditPayment implements Payment {
	private static final double DISCOUNT_RATE = 0.0;

	@Override
	public Cost getCostByPaymentMethod(Cost costs) {
		System.out.println("신용카드 결제");
		return costs;
	}
}
