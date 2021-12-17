package domain;

public enum EnumTemplate {
	NAME_1(1),
	NAME_2(2);

	private final int value;

	EnumTemplate(final int value) {
		this.value = value;
	}

	// 추가 기능 구현
	public int getValue() {
		return value;
	}

	public String toString() {
		return Integer.toString(value);
	}
}
