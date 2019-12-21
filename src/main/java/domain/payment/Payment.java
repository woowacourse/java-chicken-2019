package domain.payment;

import domain.purchase.Cost;
import domain.order.TableOrder;

public interface Payment {
	default Cost getPayedCost(TableOrder tableOrder) {
		Cost costs = tableOrder.getAllOriginCost();
		costs = costs.getChickenDiscountCost(tableOrder);
		return getCostByPaymentMethod(costs);
	}

	Cost getCostByPaymentMethod(Cost costs);
}
