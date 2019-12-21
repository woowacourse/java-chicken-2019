package domain;

public class Purchase {
	private final TableOrder tableOrder;
	private final Payment payment;

	public Purchase(TableOrder tableOrder, Payment payment) {
		this.tableOrder = tableOrder;
		this.payment = payment;
	}

	public void calculate() {

	}
}
