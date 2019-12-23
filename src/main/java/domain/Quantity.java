package domain;

public class Quantity {
    private static final int MIN_ORDER_QUANTITY = 1;
    private static final int MAX_ORDER_QUANTITY = 99;

    private int quantity = 0;

    public Quantity() {
    }

    public void putQuantity(int inputQuantity) {
        if (checkOrderQuantity(inputQuantity)) {
            this.quantity = inputQuantity;
            return;
        }
    }

    public static boolean checkOrderQuantity(int inputQuantity) {
        return inputQuantity <= MAX_ORDER_QUANTITY && inputQuantity >= MIN_ORDER_QUANTITY;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addQuantity(int addedQuantity) {
        quantity += addedQuantity;
    }

}
