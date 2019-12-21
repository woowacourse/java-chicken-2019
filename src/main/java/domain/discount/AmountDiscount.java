package domain.discount;

import domain.Payment;

public class AmountDiscount implements DiscountStrategy {

    private static final int BOUND = 10;
    private static final double DISCOUNT_PROCE = 10000;

    @Override
    public boolean support(Payment payment) {
        int amount = payment.getAmount();
        return amount >= BOUND;
    }

    private boolean notSupport(Payment payment) {
        return !support(payment);
    }

    @Override
    public double apply(double nowPrice, Payment payment) {
        if (notSupport(payment)) {
            return nowPrice;
        }

        int amount = payment.getAmount();
        int discountCount = amount / BOUND;

        return nowPrice - DISCOUNT_PROCE * discountCount;
    }

}
