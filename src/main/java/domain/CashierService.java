package domain;

public interface CashierService {
    Money discountByCash(Money originalMoney);
    Money discountByChickenQuantity(Money originalMoney, int chickenQuantity);
}
