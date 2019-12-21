package domain;

public interface CashierService {

    int getChickenQuantity();

    Money discountByCash();

    Money discountByChickenQuantity();
}
