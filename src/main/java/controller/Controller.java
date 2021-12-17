package controller;

import controller.run.OrderController;
import controller.run.PaymentController;
import controller.view.InputController;
import domain.repository.TableStateRepository;
import view.OutputView;

public class Controller {
	public Controller() {
		run();
	}

	private void run() {
		OutputView.printMainList();
		int mainNumber = InputController.getMainNumber();
		if (mainNumber == 1) {
			new OrderController().run();
		}
		if (mainNumber == 2) {
			new PaymentController().run();
		}
		if (mainNumber == 3) {
			return;
		}
		System.out.println(new TableStateRepository());
		run();
	}
}
