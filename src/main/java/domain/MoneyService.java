package domain;

public interface MoneyService {
    double getAmount();

    Money discountByAmount(double amount);

    Money discountByRatio(double ratio);
}
