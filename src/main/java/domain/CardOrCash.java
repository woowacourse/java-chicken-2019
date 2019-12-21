package domain;

import static view.InputView.*;

public class CardOrCash {
	private static final int CARD = 1;
	private static final int CASH = 2;
	private int cardOrCash;

	public CardOrCash(int cardOrCash) {
		if (cardOrCash != CARD || cardOrCash != CASH) {
			throw new IllegalArgumentException(INVALID_CARD_CASH_NUMBER);
		}
		this.cardOrCash = cardOrCash;
	}

	public boolean isCash(int cardOrCash) {
		return this.cardOrCash == CASH;
	}
}
