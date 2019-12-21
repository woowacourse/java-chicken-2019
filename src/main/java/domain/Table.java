package domain;

public class Table {
	private final int number;
	private OrderStorage orders = new OrderStorage();
	private boolean isOrdered = false;

	public Table(final int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	public void enterOrder() {
		orders.enterNewOrder();
		this.isOrdered = true;
	}

	public OrderStorage getOrders() {
		if (orders.isEmpty()) {
			throw new IllegalArgumentException("주문이 없는 테이블입니다");
		}
		return this.orders;
	}

	public String convertStateToSTring() {
		if (this.isOrdered) {
			return "└ \\ ┘";
		}
		return "└ ─ ┘";
	}
}
