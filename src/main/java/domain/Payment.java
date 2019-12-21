package domain;

public class Payment {
    private static final int CREDIT_CARD_VALUE = 1;
    private static final int CASH_VALUE = 2;
    private static final double CASH_DISCOUNT_RATE = 0.05;

    private final int select;

    public Payment(int select) {
        if ((select != CASH_VALUE) && (select != CREDIT_CARD_VALUE)) {
            throw new IllegalArgumentException("1또는 2가 아닙니다.");
        }
        this.select = select;
    }

   
}
