package work;

import java.util.InputMismatchException;
import java.util.stream.Collectors;

import domain.Table;
import view.InputView;
import view.OutputView;

public class Order extends TableWork {
	private static final int MAX_QUANTITY=99;
	private static final String QUANTITY_WARNING="주문 수량을 확인해 주세요.";

	public void run() {
		OutputView.printTables(tables);
		int tableNumber = getTableNumber();
		OutputView.printMenus(menus);
		int menuChoice = getMenuChoice();
		int menuQuantity = getMenuQuantity(tableNumber,menuChoice);
		commitOrder(tableNumber,menuChoice,menuQuantity);
	}

	private void commitOrder(int tableNumber, int menuChoice, int menuQuantity) {
		tables.stream().filter(table -> table.getNumber()==tableNumber)
			.findFirst().orElse(new Table(-1)).putOrder(menuChoice,menuQuantity);
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

	private int getMenuQuantity(int tableNumber, int menuChoice) {
		int value;
		try {
			value = InputView.inputMenuQuantity();
			int orderedQuantity = tables.stream().filter(table -> table.getNumber()==tableNumber)
				.findFirst().orElse(new Table(-1)).getOrderQuantity(menuChoice);
			Validation.checkPositiveRange(value, MAX_QUANTITY- orderedQuantity);
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
			InputView.flush();
			return getMenuQuantity(tableNumber, menuChoice);
		} catch (Exception e) {
			System.out.println();
			return 0;
		}
		return value;
	}
}
