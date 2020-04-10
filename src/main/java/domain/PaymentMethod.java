package domain;

import java.util.Arrays;
import view.IllegalUserInputException;

public enum PaymentMethod {
    CREDIT_CARD(1),
    CASH(2);

    private int code;

    PaymentMethod(int code) {
        this.code = code;
    }

    public PaymentMethod of(int code) {
        return Arrays.stream(values())
            .filter(paymentMethod -> paymentMethod.code == code)
            .findFirst()
            .orElseThrow(() ->
                new IllegalUserInputException("존재하지 않는 결제방식 번호입니다."));
    }
}
