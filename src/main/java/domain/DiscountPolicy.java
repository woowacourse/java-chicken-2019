package domain;

import java.util.List;

public class DiscountPolicy {
    private static final float cashDiscountRatio = (float) 0.05;
    private static final int chickenQuantityForDiscount = 10;
    private static final int chickenDiscountPrice = 10000;

    public float cashDiscount(boolean isCash) {
        if (isCash)
            return 1 - cashDiscountRatio;

        return 1;
    }

    public int QuantityDiscount(List<Menu> menuList) {
        int chickenAQuantity = 0;
        for (Menu it : menuList) {
            if (it.isChicken())
                chickenAQuantity += 1;
        }

        int discountAmount = (chickenAQuantity % chickenQuantityForDiscount) * chickenDiscountPrice;
        if (discountAmount < 0) {
            throw new IllegalArgumentException("System err, 할인액이 음수입니다.");
        }

        return (chickenAQuantity % chickenQuantityForDiscount) * chickenDiscountPrice;
    }
}
