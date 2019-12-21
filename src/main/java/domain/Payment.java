package domain;

public interface Payment {
	default Cost getPayedCost(TableOrder tableOrder) {
		Cost costs = tableOrder.getAllOriginCost();
		costs = costs.getChickenDiscountCost(tableOrder);
		return getCostByPaymentMethod(costs);
	}

	Cost getCostByPaymentMethod(Cost costs);
}
