package domain;

public class Cashier implements CashierService {
    private static final int TEN = 10;
    private static final int TEN_THOUSAND = 10000;
    private static final double CASH_DISCOUNT_RATIO = 0.05;
    private Order order;

    public Cashier(Order order) {
        this.order = order;
    }

    private Money getTotalOriginal() {
        return new Money(order.getTotalCost());
    }

    public int getChickenQuantity() {
        return order.getChickenQuantity();
    }

    @Override
    public Money discountByCash() {
        return discountByChickenQuantity().discountByRatio(CASH_DISCOUNT_RATIO);
    }

    @Override
    public Money discountByChickenQuantity() {
        double amountToDiscount = Math.floor(getChickenQuantity() / TEN) * TEN_THOUSAND;
        return getTotalOriginal().discountByAmount(amountToDiscount);
    }
}
