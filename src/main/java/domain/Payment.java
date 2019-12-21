package domain;

public class Payment {
    private static final int PAYMENT_MIN = 0;
    private static final int AMOUNT_MIN = 0;
    private static final int TEN = 10;
    private static final int CASH = 2;
    private static final int DISCOUNT = 10000;
    private static final double CASH_DISCOUNT_RATIO = 0.95;

    private final int paymentAmount;
    private final int chickenAmount;

    public Payment(int paymentAmount, int chickenAmount) {
        if (paymentAmount < PAYMENT_MIN) {
            throw new IllegalArgumentException("주문 가격은 " + PAYMENT_MIN + "이상이어야 합니다.");
        }
        if (chickenAmount < AMOUNT_MIN) {
            throw new IllegalArgumentException("주문 수량은 " + AMOUNT_MIN + "이상이어야 합니다.");
        }
        this.paymentAmount = paymentAmount;
        this.chickenAmount = chickenAmount;
    }

    public Payment addPaymentAmount(int paymentAmount, int chickenAmount) {
        return new Payment(this.paymentAmount + paymentAmount, this.chickenAmount + chickenAmount);
    }
}
