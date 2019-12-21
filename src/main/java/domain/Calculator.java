package domain;

import view.InputView;

public class Calculator {
    public static final int CARD_PAYMENT = 1;
    public static final int CASH_PAYMENT = 2;
    private static final double CASH_DISCOUNT = 0.95;

    public static int cashAndCard(Table table) {
        System.out.println("## " + table.getNumber() + " 번 테이블의 결제를 진행합니다.");
        if (InputView.inputPaymentMethod() == CARD_PAYMENT) {
            return table.allPrices();
        }
        return (int) (table.allPrices() * CASH_DISCOUNT);
    }
}
