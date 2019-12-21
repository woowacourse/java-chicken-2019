package domain;

public enum Requests {
    Register(1),
    Pay(2),
    Exit(3);

    private int value;

    Requests(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
