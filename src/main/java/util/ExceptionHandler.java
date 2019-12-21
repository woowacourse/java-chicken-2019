package util;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import domain.Menu;
import domain.Table;

public class ExceptionHandler {
	private static final int ORDER = 1;
	private static final int PAYMENT = 2;
	private static final int EXIT = 3;
	private static final int MAXIMUM_ORDER_COUNT = 99;
	private static final int CREDIT_CARD = 1;
	private static final int CASH = 2;
	private static Scanner scanner = new Scanner(System.in);

	public static int inputSelectWorkHandler() {
		try {
			return checkInputSelectWorkHandler(scanner.nextInt());
		} catch (InputMismatchException | IllegalArgumentException e) {
			System.out.println("입력값을 확인해주세요.");
			scanner = new Scanner(System.in);
			return inputSelectWorkHandler();
		}
	}

	private static int checkInputSelectWorkHandler(int input) {
		if (input == ORDER || input == PAYMENT || input == EXIT) {
			return input;
		}
		throw new IllegalArgumentException();
	}

	public static int inputSelectTableHandler(List<Table> tables) {
		try {
			return checkInputSelectTableHandler(tables, scanner.nextInt());
		} catch (InputMismatchException | IllegalArgumentException e) {
			System.out.println("입력값을 확인해주세요.");
			scanner = new Scanner(System.in);
			return inputSelectTableHandler(tables);
		}
	}

	private static int checkInputSelectTableHandler(List<Table> tables, int input) {
		for (Table table : tables) {
			if (table.getNumber() == input) {
				return input;
			}
		}
		throw new IllegalArgumentException();
	}

	public static int inputSelectMenuHandler(List<Menu> menus) {
		try {
			return checkInputSelectMenuHandler(menus, scanner.nextInt());
		} catch (InputMismatchException | IllegalArgumentException e) {
			System.out.println("입력값을 확인해주세요.");
			scanner = new Scanner(System.in);
			return inputSelectMenuHandler(menus);
		}
	}

	private static int checkInputSelectMenuHandler(List<Menu> menus, int input) {
		for (Menu menu : menus) {
			if (menu.getNumber() == input) {
				return input;
			}
		}
		throw new IllegalArgumentException();
	}

	public static int inputSelectMenuCountHandler(Table table) {
		try {
			return checkInputSelectMenuCountHandler(table,scanner.nextInt());
		} catch (InputMismatchException | IllegalArgumentException e) {
			System.out.println("입력값을 확인해주세요.");
			scanner = new Scanner(System.in);
			return inputSelectMenuCountHandler(table);
		}
	}

	private static int checkInputSelectMenuCountHandler(Table table, int input) {
		if (input<=0) {
			throw new IllegalArgumentException();
		}
		if (table.getOrderCount() + input > MAXIMUM_ORDER_COUNT) {
			System.out.println("주문 수량이 99를 초과했습니다.");
			throw new IllegalArgumentException();
		}
		return input;
	}

	public static int inputSelectHowToPayHandler() {
		try {
			return checkInputSelectHowToPayHandler(scanner.nextInt());
		} catch (InputMismatchException | IllegalArgumentException e) {
			System.out.println("입력값을 확인해주세요.");
			scanner = new Scanner(System.in);
			return inputSelectHowToPayHandler();
		}
	}

	private static int checkInputSelectHowToPayHandler(int input) {
		if (input ==CREDIT_CARD || input == CASH) {
			return input;
		}
		throw new IllegalArgumentException();
	}

}
