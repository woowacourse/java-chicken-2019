package utils;

public class Calculate {
    private final static int CARD = 1;
    private final static int TEN = 10;
    private final static int TEN_THOUSAND = 10000;
    private final static double CASH_DISCOUNT = 0.95;

    public static int amountCalculation(int price, int chickenCount, int paymentType) {
        if (paymentType == CARD)
            return price - (chickenCount / TEN) * TEN_THOUSAND;
        return (int) ((price - (chickenCount / TEN) * TEN_THOUSAND) * CASH_DISCOUNT);
    }
}
