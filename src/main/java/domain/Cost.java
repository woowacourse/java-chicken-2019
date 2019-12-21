package domain;

public class Cost {
	public static final Cost ZERO = new Cost(0);

	private static final int MIN_PRICE_VALUE = 0;
	private static final double ORIGIN_PRICE_RATE = 100.0;
	private static final int CHICKEN_DISCOUNT_EA = 10;
	private static final int CHICKEN_DISCOUNT_PRICE = 10_000;

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

	public Cost getDisCountedPrice(double discountRate) {
		return new Cost(getDiscountedPriceByRate(discountRate));
	}

	private int getDiscountedPriceByRate(double discountRate) {
		return (int)((price * (ORIGIN_PRICE_RATE - discountRate)) / ORIGIN_PRICE_RATE);
	}

	public Cost getChickenDiscountCost(TableOrder tableOrder) {
		int countOfChickenOrder = tableOrder.getCountOfChickenOrder();
		return new Cost(getDiscountedPriceByChickenEA(countOfChickenOrder));
	}

	private int getDiscountedPriceByChickenEA(int countOfChickenOrder) {
		return price - (countOfChickenOrder / CHICKEN_DISCOUNT_EA) * CHICKEN_DISCOUNT_PRICE;
	}
}
