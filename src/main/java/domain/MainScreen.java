package domain;

import java.util.Arrays;

public enum MainScreen {
	ORDER(1),
	PAYMENT(2),
	EXIT(3);

	private static final String ID_ERROR = "주문등록(1), 결제하기(2), 프로그램 종료(3) 중 하나를 입력하세요.";

	private final int id;

	MainScreen(int id) {
		this.id = id;
	}

	public static MainScreen valueOf(int id) {
		return Arrays.stream(values())
				.filter(item -> item.id == id)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(ID_ERROR));
	}

	public boolean isOrder() {
		return this == ORDER;
	}

	public boolean isPayment() {
		return this == PAYMENT;
	}

	public boolean isExit() {
		return this == EXIT;
	}
}
