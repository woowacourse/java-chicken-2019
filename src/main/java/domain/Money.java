package domain;

public class Money {
    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Money discountByAmount(int amount) {
        this.amount -= amount;
        return new Money(this.amount);
    }

    public Money discountByRatio(double ratio) {
        this.amount *= (1 - ratio);
        return new Money(this.amount);
    }
}
