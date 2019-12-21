package domain;

import java.util.stream.Stream;

/**
 * 결제 타입을 의미하는 열거형
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-21
 */
public enum PaymentType {
	CREDIT_CARD("1", 0),
	CASH("2", 5);

	private String text;
	private int discountRate;

	PaymentType(String text, int discountRate) {
		this.text = text;
		this.discountRate = discountRate;
	}

	public static PaymentType of(String text) {
		return Stream.of(PaymentType.values())
				.filter(payment -> payment.text.equals(text))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 선택입니다."));
	}

	public int calculateDiscountedPrice(int money) {
		return money - (money / 100 * discountRate);
	}
}
