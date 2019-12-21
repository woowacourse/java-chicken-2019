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
            throw new IllegalArgumentException("결재 수단은 신용카드 1번, 현금 2번, 두가지만 가능합니다.");
        }
    }

    public boolean isCash() {
        return paymentMethod == CASH;
    }
}
