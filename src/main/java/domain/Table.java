package domain;

public class Table {
	private final int number;

	public Table(final int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	boolean containTableNumber(int tableNumber) {
		return this.number == tableNumber;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
