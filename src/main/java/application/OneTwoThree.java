package application;

import view.InputView;

public class OneTwoThree {
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	
	public OneTwoThree() {}
		
	public static int askWhichApplication() {
		try {
			int input = InputView.enterApplication();
			checkValidInt(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askWhichApplication();
		}
	}
		
	private static void checkValidInt(int input) {
		if (input != ONE && input != TWO && input != THREE) {
			throw new IllegalArgumentException("1,2,3만 입력해주세요");
		}
	}
}
