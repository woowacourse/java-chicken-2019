package domain.discount;

import domain.Payment;

public interface DiscountStrategy {
    boolean support(Payment payment);

    double apply(double originalPrice, Payment payment);
}
