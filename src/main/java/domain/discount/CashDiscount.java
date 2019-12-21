package domain.discount;

import domain.Payment;

public class CashDiscount implements DiscountStrategy {

    private static final double CASH_DISCOUNT_RATE = 0.95;

    @Override
    public boolean support(Payment payment) {
        return payment.isCash();
    }

    @Override
    public double apply(double originalPrice, Payment payment) {
        if (support(payment)) {
            return originalPrice * CASH_DISCOUNT_RATE;
        }
        return originalPrice;
    }

}
