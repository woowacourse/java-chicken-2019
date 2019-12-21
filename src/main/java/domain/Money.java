package domain;

public class Money implements MoneyService{
    private double amount;

    public Money(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Money discountByAmount(double amount) {
        this.amount -= amount;
        return new Money(this.amount);
    }

    public Money discountByRatio(double ratio) {
        this.amount *= (1 - ratio);
        return new Money(this.amount);
    }
}
