package domain;

import java.util.Arrays;

public enum PaymentType {
	CREDIT_CARD(1),
	CASH(2);

	private static final String TYPE_ERROR = "신용 카드(1), 현금(2) 중 하나를 입력하세요.";

	private final int type;

	PaymentType(int type) {
		this.type = type;
	}

	public static PaymentType valueOf(int type) {
		return Arrays.stream(values())
				.filter(item -> item.type == type)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(TYPE_ERROR));
	}

	public boolean isCash() {
		return this == CASH;
	}
}
