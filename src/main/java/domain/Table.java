package domain;

public class Table {
    private final int number;
    private final Orders orders = new Orders();

    public Table(final int number) {
        this.number = number;
    }

	@Override
    public String toString() {
        return Integer.toString(number);
    }
	
	public boolean isSame(Table compare) {
		return Integer.toString(number).equals(compare.toString());
	}
	
	public Orders toOrders() {
		return orders;
	}
}
