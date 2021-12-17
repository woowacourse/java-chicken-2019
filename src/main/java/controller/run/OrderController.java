package controller.run;

import controller.view.InputController;
import domain.User;
import domain.repository.MenuRepository;
import domain.repository.TableRepository;
import view.OutputView;

public class OrderController {
	public void run() {
		try {
			setTable(getTableNumber(), getMenuNumber(), getMenuCount());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			run();
		}
	}

	private void setTable(int tableNumber, int menuNumber, int menuCount) {
		if (TableRepository.isUserEmpty(tableNumber)) {
			TableRepository.initiateTableUser(tableNumber, new User(menuNumber, menuCount));
			return;
		}
		TableRepository.getUser(tableNumber).addMenu(menuNumber, menuCount);
	}

	private int getTableNumber() {
		OutputView.printTables(TableRepository.tables());
		return InputController.getTableNumber();
	}

	private int getPayTableNumber() {
		OutputView.printTables(TableRepository.tables());
		return InputController.getPayTableNumber();
	}

	private int getMenuNumber() {
		OutputView.printMenus(MenuRepository.menus());
		return InputController.getMenuNumber();
	}

	private int getMenuCount() {
		return InputController.getMenuCount();
	}
}
