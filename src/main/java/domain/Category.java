package domain;

public enum Category {
	CHICKEN("치킨"),
	BEVERAGE("음료"),
	FAILURE("주문실패");

	private final String name;

	Category(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[" + name + "]";
	}
}