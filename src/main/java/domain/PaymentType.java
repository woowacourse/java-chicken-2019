package domain;

public enum PaymentType {
    CARD(1),
    CASH(2);

    private int type;


    PaymentType(int type) {
        this.type = type;
    }

}
