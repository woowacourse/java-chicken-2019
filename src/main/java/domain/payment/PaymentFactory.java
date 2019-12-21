package domain.payment;

public class PaymentFactory {
	private static final int CREDIT_CODE = 1;
	private static final int CASH_CODE = 2;

	public static Payment getInstance(int code) {
		if (code == CREDIT_CODE) {
			return new CreditPayment();
		}
		if (code == CASH_CODE) {
			return new CashPayment();
		}
		throw new IllegalArgumentException("올바른 코드를 입력해주세요.");
	}
}
