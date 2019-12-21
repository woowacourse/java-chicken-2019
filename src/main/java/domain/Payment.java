package domain;

public enum Payment {
    CARD(1, 0),
    CASH(2, 0.05);

    private int paymentNumber;
    private double discountRatio;

    Payment(int paymentNumber, double discountRatio) {
        this.paymentNumber = paymentNumber;
        this.discountRatio = discountRatio;
    }

    public boolean isMatchPaymentNumber(int paymentNumber) {
        return this.paymentNumber == paymentNumber;
    }

    public double calculateTotalDiscountedPrice(int totalPrice){
        if (this.paymentNumber == 2) {
            return totalPrice - totalPrice * discountRatio;
        }
        return totalPrice;
    }
}
