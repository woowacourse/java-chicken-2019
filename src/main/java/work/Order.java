package work;

import java.util.InputMismatchException;
import java.util.stream.Collectors;

import view.InputView;
import view.OutputView;

public class Order extends TableWork {

	public void run() {
		OutputView.printTables(tables);
		int tableNumber = getTableNumber();
		OutputView.printMenus(menus);
		int menuChoice = getMenuChoice();
		int menuQuantity = getMenuQuantity();

	}

	private int getMenuChoice() {
		int value;
		try {
			value = InputView.inputMenuChoice();
			Validation.checkInList(value, menus.stream()
				.map(menu -> menu.getNumber())
				.collect(Collectors.toList()));
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
			InputView.flush();
			return getMenuChoice();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getMenuChoice();
		}
		return value;
	}

	private int getMenuQuantity() {
		int value;
		try {
			value = InputView.inputMenuQuantity();
			Validation.checkPositiveRange(value, menus.size());
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
			InputView.flush();
			return getMenuQuantity();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getMenuQuantity();
		}
		return value;
	}
}
