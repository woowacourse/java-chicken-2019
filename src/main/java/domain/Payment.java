package domain;

public interface Payment {
	default Cost getPayedCost(TableOrder tableOrder) {
		Cost costs = tableOrder.getAllOriginCost();

		return getCostByPaymentMethod(costs);
	}

	Cost getCostByPaymentMethod(Cost costs);
}
