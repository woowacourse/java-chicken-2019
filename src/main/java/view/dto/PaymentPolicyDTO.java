package view.dto;

import domain.payment.PaymentPolicy;

public class PaymentPolicyDTO {
    private static final int CREDIT = 1;
    private static final int CASH = 2;

    private final int policyNumber;

    public PaymentPolicyDTO(int policyNumber) {
        validate(policyNumber);
        this.policyNumber = policyNumber;
    }

    private void validate(int policy) {
        if (policy != CREDIT && policy != CASH) {
            throw new IllegalArgumentException(policy + "는 존재하지 않는 결제 수단입니다.");
        }
    }

    private PaymentPolicy toEntity() {
        return PaymentPolicy.findPolicyByNumber(policyNumber);
    }

}
