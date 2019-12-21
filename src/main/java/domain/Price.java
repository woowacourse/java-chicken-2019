package domain;

public class Price {
	private double price;

	public Price(int price, double discounts) {
		this.price = price * (1 - discounts);
	}

	public double getPrice() {
		return price;
	}
}
