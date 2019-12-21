package domain;

public class Order {
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int TWO_ONE = 21;
	private static final int TWO_TWO = 22;
	private static final int MIN_AMOUNT = 1;
	private static final int MAX_AMOUNT = 99;
	
	private int menuNum;
	private int amount;
	
	public Order(int menuNum, int amount) {
		checkValidNumOfMenu(menuNum);
		checkValidAmountOfMenu(amount);
		this.menuNum = menuNum;
		this.amount = amount;
	}
	
	public void addAmount(int amount) {
		checkValidAmountOfMenu(this.amount + amount);
		this.amount += amount;
	}
	
	public boolean isSameMenu(int menuNum) {
		if (this.menuNum == menuNum) {
			return true;
		}
		return false;
	}
	
	public int getNum() {
		return this.menuNum;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	private void checkValidNumOfMenu(int input) {
		if ((input != ONE) && (input != TWO) && (input != THREE) && (input != FOUR)
				&& (input != FIVE) && (input != SIX) && (input != TWO_ONE) && (input != TWO_TWO)) {
			throw new IllegalArgumentException("적절한 메뉴 번호를 입력해주세요");
		}
	} 
	
	private void checkValidAmountOfMenu(int input) {
		if (input < MIN_AMOUNT || input > MAX_AMOUNT) {
			throw new IllegalArgumentException("1개 이상, 99개 이하를 입력해주세요");
		}
	}
}
