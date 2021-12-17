package controller;

import controller.run.OrderController;
import controller.run.PaymentController;
import controller.view.InputController;
import domain.repository.TableRepository;
import view.OutputView;

public class SystemController {
	public static final int ORDER_NUM = 1;
	public static final int PAY_NUM = 2;
	public static final int QUIT_NUM = 3;

	public SystemController() {
		run();
	}

	private void run() {
		OutputView.printMainList();
		int mainNumber = InputController.getMainNumber();
		if (mainNumber == ORDER_NUM) {
			new OrderController().run();
		}
		if (mainNumber == PAY_NUM) {
			new PaymentController().run();
		}
		if (mainNumber == QUIT_NUM) {
			return;
		}
		run();
	}
}
