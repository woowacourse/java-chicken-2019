package domain;

public class Table {
	private final int number;
	private final boolean use;

	public Table(final int number) {
		this.number = number;
		this.use = false;
	}

	public boolean isUse() {
		return use;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
