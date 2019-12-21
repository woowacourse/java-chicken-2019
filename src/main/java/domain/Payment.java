package domain;

import domain.payment.PaymentPolicy;

public class Payment {
    private final Orders orders;
    private final PaymentPolicy paymentPolicy;

    public Payment(Orders orders, PaymentPolicy paymentPolicy) {
        this.orders = orders;
        this.paymentPolicy = paymentPolicy;
    }

    public int getAmount() {
        return orders.getChickenAmount();
    }

    public boolean isCash() {
        return paymentPolicy.isCash();
    }

    public double getPrice() {
        return orders.getPrice();
    }
}
