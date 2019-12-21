package view;

public class CacheOrCard {
	private static final int NUM_FOR_CARD = 1;
	private static final int NUM_FOR_CACHE = 2;
	
	boolean yesNo;
	
	public CacheOrCard(int input) {
		checkValidInput(input);
		yesNo = convertIntToBool(input);
	}
	
	public boolean isCache() {
		return this.yesNo;
	}
	
	private void checkValidInput(int input) {
		if (input != NUM_FOR_CACHE && input != NUM_FOR_CARD) {
			throw new IllegalArgumentException("1 또는 2만 입력해주세요");
		}
	}
	
	private boolean convertIntToBool(int input) {
		if (input == NUM_FOR_CACHE) {
			return true;
		}
		return false;
	}
}
