package payment;

import domain.Table;

class DiscountCalcurater {
    private static final int ZERO = 0;
    private static final int TEN = 10;
    private static final double MONEY_DISCOUTN_RATE = 0.05;
    private static final int MILLION = 10000;

    static int discountChickenNumber(Table table, int noneDiscountTotalPrice) {
        int chickenCount = table.getOrderedMenus().calcurateChickenCount();
        while (chickenCount > ZERO) {
            if (chickenCount >= TEN) {
                noneDiscountTotalPrice -= MILLION;
            }
            chickenCount -= TEN;
        }
        return noneDiscountTotalPrice;
    }

    static double discountMoney(int noneDiscountMoneyPrice) {
        return noneDiscountMoneyPrice - (noneDiscountMoneyPrice * MONEY_DISCOUTN_RATE);
    }
}
