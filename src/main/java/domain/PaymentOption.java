package domain;

public class PaymentOption {
	private final int creditCard = 1;
	private final int cash = 2;
	private final int value;
	
	public PaymentOption(final int value) {
		this.value = value;
		if (this.value != creditCard && this.value != cash) {
			throw new IllegalArgumentException("입력 번호는 1(신용카드), 2(현금)번만 가능합니다.");
		}
	}
}
