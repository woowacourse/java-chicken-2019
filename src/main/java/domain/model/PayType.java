package domain.model;

public enum PayType {
    CASH(1, "현금"),
    CARD(2, "카드");

    private int typeNumber;
    private String typeName;

    PayType(int typeNumber, String typeName) {
        this.typeNumber = typeNumber;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeNumber + ". " + typeName;
    }
}
