package domain;

public class MenuAmount {
	private static final int MAX_AMOUNT = 99;

	private final int amount;

	public MenuAmount(int amount) {
		checkAmount(amount);
		this.amount = amount;
	}

	private void checkAmount(int amount) {
		if (amount > MAX_AMOUNT) {
			throw new IllegalArgumentException("한 메뉴의 최대 수량은 99개 입니다.");
		}
	}
}
