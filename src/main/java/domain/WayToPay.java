package domain;

public enum WayToPay {
    creditCard(1),
    cash(2);

    private int value;

    WayToPay(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
