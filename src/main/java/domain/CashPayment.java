package domain;

public class CashPayment implements Payment{
	private static final double CASH_DISCOUNT_RATE = 0.0;

	@Override
	public Cost getCostByPaymentMethod(Cost costs) {
		System.out.println("현금 결제");
		return costs.getDisCountedPrice(CASH_DISCOUNT_RATE);
	}
}
