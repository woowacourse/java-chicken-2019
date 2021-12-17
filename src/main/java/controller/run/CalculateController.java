package controller.run;

import domain.repository.TableRepository;

public class CalculateController {
	public static final double DISCOUNT_RATE = 0.95;

	public static int getDiscountPay(int tableNum) {
		return TableRepository.getUser(tableNum).getNoDiscountPay();
	}

	public static int getCashPay(int tableNum) {
		return (int)(getDiscountPay(tableNum) * DISCOUNT_RATE);
	}
}
