package domain;

public class Receipt {
	private static final double CASH_SALE = 0.05;

	private final int price;
	private final PaymentType paymentType;

	public Receipt(int price, PaymentType paymentType) {
		this.price = price;
		this.paymentType = paymentType;
	}

	public int totalPrice() {
		if (paymentType.isCash()) {
			return (int)(price - price * CASH_SALE);
		}
		return price;
	}
}
