package domain;

public class Amount {
	private static final int MIN = 1;
	private static final int MAX = 99;
	private static final String AMOUNT_ERROR = "수량은 1 이상 99이하만 가능합니다.";

	private final int amount;

	public Amount(int amount) {
		validate(amount);
		this.amount = amount;
	}

	public static void validate(int amount) {
		if (amount < MIN || amount > MAX) {
			throw new IllegalArgumentException(AMOUNT_ERROR);
		}
	}
}
