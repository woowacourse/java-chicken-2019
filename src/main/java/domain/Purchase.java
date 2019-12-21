package domain;

import view.OutputView;

public class Purchase {
	private final TableOrder tableOrder;
	private final Payment payment;

	public Purchase(TableOrder tableOrder, Payment payment) {
		this.tableOrder = tableOrder;
		this.payment = payment;
	}

	public void calculate() {
		doPay();
		requestToRemovePayedOrder();
	}

	private void doPay() {
		Cost cost = payment.getCost(tableOrder);
		OutputView.printPurchaseInfo(cost);
	}

	private void requestToRemovePayedOrder() {
		tableOrder.removeOrdersInfo();
	}
}
