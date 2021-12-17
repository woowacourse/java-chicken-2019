package controller;

import controller.view.InputController;
import domain.User;
import domain.repository.MenuRepository;
import domain.repository.TableRepository;
import domain.repository.TableStateRepository;
import view.OutputView;

public class Controller {
	public Controller() {
		start();
	}

	private void start() {
		// 작동 시작
		OutputView.printMainList();
		int mainNumber = InputController.getMainNumber();
		if (mainNumber == 1) {
			runOrder();
		}
		if (mainNumber == 2) {
			runPayment();
		}
		if (mainNumber == 3) {
			return;
		}
		System.out.println(new TableStateRepository());
		start();
	}

	private void runOrder() {
		try {
			setTable(getTableNumber(), getMenuNumber(), getMenuCount());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			runOrder();
		}
	}

	private void runPayment() {

	}

	private void setTable(int tableNumber, int menuNumber, int menuCount) {
		if (TableStateRepository.isUserEmpty(tableNumber)) {
			TableStateRepository.initiateTableUser(tableNumber, new User(tableNumber, menuNumber, menuCount));
			return;
		}
		TableStateRepository.getUser(tableNumber).addMenu(menuNumber, menuCount);
	}

	private int getTableNumber() {
		OutputView.printTables(TableRepository.tables());
		return InputController.getTableNumber();
	}

	private int getMenuNumber() {
		OutputView.printMenus(MenuRepository.menus());
		return InputController.getMenuNumber();
	}

	private int getMenuCount() {
		return InputController.getMenuCount();
	}
}
