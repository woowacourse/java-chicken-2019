package view.dto;

public class PaymentType {
    int type;

    public PaymentType(int paymentType) {
        if (paymentType == 1 || paymentType == 2) {
            this.type = paymentType;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int getType() {
        return type;
    }

    public boolean isTypeCard() {
        return type == 1;
    }

    public boolean isTypeMoney() {
        return type == 2;
    }
}
