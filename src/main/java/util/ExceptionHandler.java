package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandler {
	private static final int ORDER = 1;
	private static final int PAYMENT = 2;
	private static final int EXIT = 3;
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

}
