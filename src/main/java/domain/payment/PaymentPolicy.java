package domain.payment;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum PaymentPolicy {
    CREDIT("신용카드", 1),
    CASH("현금", 2);

    private final String methodName;
    private final int policyNumber;

    PaymentPolicy(String methodName, int policyNumber) {
        this.methodName = methodName;
        this.policyNumber = policyNumber;
    }

    public static PaymentPolicy findPolicyByNumber(int policyNumber) {
        return Arrays.stream(values())
                .filter(paymentPolicy -> paymentPolicy.equalNumber(policyNumber))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private boolean equalNumber(int policyNumber) {
        return this.policyNumber == policyNumber;
    }

    public boolean isCash() {
        return this.equals(CASH);
    }
}
