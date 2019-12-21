import domain.Menu;

import java.util.HashMap;

public class Discount {
    private static final int CASH = 2;
    private static final float DISCOUNT_RATIO_PAYMENT_BY_CASH = (float) 0.05;
    private static final int DISCOUNT_LIMIT_NUMBER = 10;
    private static final int INITIALIZE_TO_ZERO = 0;

    public static int calculateDiscountByNumberOfMenu(HashMap<Menu,Integer> order, int payment) {
        int number = 0;

        for (int value : order.values()) {
            number += value;
        }

        if (isUnderTen(number)) {
            number = INITIALIZE_TO_ZERO;
        }

        return payment - ((number / 10) * 10000);
    }

    public static int calculateDiscountByMethod(int number, int payment) {
        if (isCash(number)) {
            return calculateCashDiscount(payment);
        }

        return payment;
    }

    private static boolean isCash(int number) {
        return number == CASH;
    }

    private static boolean isUnderTen(int number) {
        return number < DISCOUNT_LIMIT_NUMBER;
    }

    private static int calculateCashDiscount(int payment) {
        return payment - ((int) (payment * DISCOUNT_RATIO_PAYMENT_BY_CASH));
    }
}
