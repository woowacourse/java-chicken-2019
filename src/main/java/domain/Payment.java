package domain;

public enum Payment {
    CARD(1, 0),
    CASH(2, 0.05);

    private final int paymentNumber;
    private final double discountRatio;

    Payment(int paymentNumber, double discountRatio) {
        this.paymentNumber = paymentNumber;
        this.discountRatio = discountRatio;
    }

    public boolean isMatchPaymentNumber(int paymentNumber) {
        return this.paymentNumber == paymentNumber;
    }

    public double calculateFinalDiscountedPrice(int totalPrice){
        if (this.equals(CASH)) {
            return totalPrice - totalPrice * discountRatio;
        }
        return totalPrice;
    }
}
