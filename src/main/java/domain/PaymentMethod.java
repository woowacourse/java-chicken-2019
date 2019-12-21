package domain;

public class PaymentMethod {
    private static final int CREDIT_CARD = 1;
    private static final int CASH = 2;
    private final int paymentMethod;

    public PaymentMethod(String inputString) {
        int paymentMethod;
        try {
            paymentMethod = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("※ 숫자만 입력 가능합니다.");
        }
        if (doesNotExistPaymentMethodNumber(paymentMethod)) {
            throw new IllegalArgumentException("※ 1, 2 중에서 입력 가능합니다.");
        }
        this.paymentMethod = paymentMethod;
    }

    private boolean doesNotExistPaymentMethodNumber(int paymentMethod) {
        return paymentMethod != CREDIT_CARD && paymentMethod != CASH;
    }

    public boolean isCash() {
        return paymentMethod == CASH;
    }
}
