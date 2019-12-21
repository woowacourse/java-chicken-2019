package domain;

import view.InputView;

public class TableNumber {
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int EIGHT = 8;
	
	private int value;
	
	public void enterNum() {
		try {
			int input = InputView.enterTableNumber();
			checkValidInt(input);
			this.value = input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			enterNum();
		}
	}
		
	private void checkValidInt(int input) {
		if ((input != ONE) && (input != TWO) && (input != THREE)
				&& (input != FIVE) && (input != SIX) && (input != EIGHT)) {
			throw new IllegalArgumentException("적절한 테이블 번호를 입력해주세요");
		}
	}
	
	public int convertNumberToIndex() {
		if (this.value == FIVE || this.value == SIX) {
			return this.value - 1;
		}
		if (this.value == EIGHT) {
			return this.value - 2;
		}
		return this.value;
	}
	
	public int getValue() {
		return this.value;
	}
}
