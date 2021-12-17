package controller.run;

import domain.repository.TableStateRepository;

public class CalculateController {
	public static int getDiscountPay(int tableNum) {
		return TableStateRepository.getUser(tableNum).getNoDiscountPay();
	}

	public static int getCashPay(int tableNum) {
		return (int)(getDiscountPay(tableNum) * 0.95);
	}
}
