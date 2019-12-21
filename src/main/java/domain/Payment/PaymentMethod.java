/*
 * @(#)PaymentMethod.java       0.1 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

package domain.Payment;

public class PaymentMethod {
    private static final int CREDIT_CARD = 1;
    private static final int CASH = 2;
    private final int paymentMethod;

    public PaymentMethod(int paymentMethod) {
        isValid(paymentMethod);

        this.paymentMethod = paymentMethod;
    }

    private void isValid(int paymentMethod) {
        if (paymentMethod != CREDIT_CARD && paymentMethod != CASH) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isCash() {
        return paymentMethod == CASH;
    }
}
