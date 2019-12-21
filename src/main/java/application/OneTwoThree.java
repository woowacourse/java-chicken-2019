package application;

import view.InputView;

public class OneTwoThree {
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	
	private int value;
	
	public OneTwoThree() {}
		
	public void enterOneTwoThree() {
		try {
			int input = InputView.enterApplication();
			checkValidInput(input);
			this.value = input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			enterOneTwoThree();
		}
	}
		
	private void checkValidInput(int input) {
		if (input != ONE && input != TWO && input != THREE) {
			throw new IllegalArgumentException("1,2,3만 입력해주세요");
		}
	}
	
	public boolean isTerminate() {
		if (this.value == THREE) {
			return true;
		}
		return false;
	}
	
	public boolean isGetOrder() {
		if (this.value == ONE) {
			return true;
		}
		return false;
	}
	
	public boolean isPay() {
		if (this.value == TWO) {
			return true;
		}
		return false;
	}
}
