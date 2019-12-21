package domain.discount;

import domain.Payment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DiscountGroup {
    AMOUNT("수량할인", new AmountDiscount()),
    CASH("현금할인", new CashDiscount());

    private final String discountName;
    private final DiscountStrategy discountStrategy;

    DiscountGroup(String discountName, DiscountStrategy discountStrategy) {
        this.discountName = discountName;
        this.discountStrategy = discountStrategy;
    }

    public static double getDiscountPrice(Payment payment) {
        double price = payment.getPrice();
        for (DiscountStrategy discountStrategy : getDiscountStrategy()) {
            price = discountStrategy.apply(price, payment);
        }
        return price;
    }

    private static List<DiscountStrategy> getDiscountStrategy() {
        return Arrays.stream(values())
                .map(discountGroup -> discountGroup.discountStrategy)
                .collect(Collectors.toList());
    }

}
