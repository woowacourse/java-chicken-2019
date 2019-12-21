package domain;

import view.InputView;

public class Calculator {
    public static final int CARD_PAYMENT = 1;
    public static final int CASH_PAYMENT = 2;
    private static final double CASH_DISCOUNT = 0.95;

    public static int cashAndCard(int charge) {

        if (InputView.inputPaymentMethod() == CARD_PAYMENT) {
            return charge;
        }
        return (int) (charge * CASH_DISCOUNT);
    }
}
