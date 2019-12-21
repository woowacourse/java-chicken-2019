package domain;

public class MenuCount {
	private final int MAXIMUM_COUNT = 99;
	private final int value;
	
	public MenuCount(final int value) {
		if (value > MAXIMUM_COUNT) {
			throw new IllegalArgumentException("99개 이상 주문할 수 없습니다.");
		}
		
		this.value = value;
	}
	
	
}
