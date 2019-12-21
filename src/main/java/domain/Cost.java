package domain;

public class Cost {
	public static final Cost ZERO = new Cost(0);

	private static final int MIN_PRICE_VALUE = 0;
	private static final double ORIGIN_PRICE_RATE = 100.0;

	private final int price;

	public Cost(int price) {
		if (price < MIN_PRICE_VALUE) {
			throw new IllegalArgumentException("올바르지 않은 가격 입니다.");
		}
		this.price = price;
	}

	public Cost add(Cost cost) {
		return new Cost(price + cost.price);
	}

	public int getPrice() {
		return price;
	}

	public Cost getDisCountedPrice(double discountRate) {
		return new Cost(discountedPrice(discountRate));
	}

	private int discountedPrice(double discountRate) {
		return (int)((price * (ORIGIN_PRICE_RATE - discountRate)) / ORIGIN_PRICE_RATE);
	}
}
