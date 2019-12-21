package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
	private static final String PROMPT_HEADER = "## ";
	private static final String PROMPT_TABLE_CHOICE = "테이블을 선택하세요.";
	private static final String PROMPT_MENU_CHOICE = "등록할 메뉴를 선택하세요.";
	private static final String PROMPT_MAIN_COMMAND = "원하는 기능을 선택하세요.";
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputTableNumber() throws InputMismatchException {
		System.out.println(PROMPT_HEADER + PROMPT_TABLE_CHOICE);
		return scanner.nextInt();
	}

	public static int inputMenuChoice() throws InputMismatchException{
		System.out.println(PROMPT_HEADER+PROMPT_MENU_CHOICE);
		return scanner.nextInt();
	}

	public static int inputMainCommand() throws InputMismatchException {
		System.out.println(PROMPT_HEADER + PROMPT_MAIN_COMMAND);
		return scanner.nextInt();
	}

	public static void flush() {
		scanner.nextLine();
	}
}
