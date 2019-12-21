package domain.order;

public class Amount {
    private int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    public void add(int addedAmount) {
        this.amount += addedAmount;
    }
}
