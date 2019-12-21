package view.dto;

public class PaymentPolicyDTO {
    private static final int CREDIT = 1;
    private static final int CASH = 2;

    private final int policy;

    public PaymentPolicyDTO(int policy) {
        validate(policy);
        this.policy = policy;
    }

    private void validate(int policy) {
        if (policy != CREDIT && policy != CASH) {
            throw new IllegalArgumentException(policy + "는 존재하지 않는 결제 수단입니다.");
        }
    }

}
