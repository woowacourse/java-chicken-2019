package domain.order;

public class Amount {
    private static final int MIN_AMOUNT = 1;
    private static final int MAX_AMOUNT = 99;

    private int amount;

    public Amount(int amount) throws IllegalArgumentException {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < MIN_AMOUNT || amount > MAX_AMOUNT) {
            throw new IllegalArgumentException("주문 수량은 1~99까지만 가능합니다.");
        }
    }

    public void add(int addedAmount) {
        if (this.amount + addedAmount > MAX_AMOUNT) {
            throw new IllegalArgumentException("메뉴당 최대 주문 수량은 99개입니다.");
        }
        this.amount += addedAmount;
    }
}
