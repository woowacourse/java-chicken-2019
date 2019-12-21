package view.dto;

public class PaymentType {
    private int type;

    public PaymentType(int paymentType) {
        if (paymentType == 1 || paymentType == 2) {
            this.type = paymentType;
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean isTypeMoney() {
        return type == 2;
    }
}
