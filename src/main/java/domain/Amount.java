package domain;

public class Amount {
    private static final int MIN = 1;
    private static final int MAX = 99;

    private int amount;

    public Amount(int amount) {
        validateBoundary(amount);
        this.amount = amount;
    }

    private void validateBoundary(int amount) {
        if (amount < MIN || amount > MAX) {
            throw new IllegalArgumentException("1개 이상 99개 이하의 메뉴만 주문이 가능합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
