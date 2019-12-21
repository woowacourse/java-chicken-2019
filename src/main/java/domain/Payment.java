package domain;

import view.InputView;

public class Payment {
    Table table;
    int paymentMethod; // 1: 신용카드, 2: 현금

    public Payment(Table table) {
        if (table == null)
            throw new IllegalArgumentException("테이블이 잘못되었습니다.");
        this.table = table;
    }

    public void pay() {
        paymentMethod = getPaymentMethod();
    }

    public int getPaymentMethod() {
        String input;
        do {
            input = InputView.inputPaymentMethod(table);
        } while (!validatePaymentMethod(input));

        return Integer.parseInt(input);
    }

    public boolean validatePaymentMethod(String input) {
        int paymetMethod = Validate.validateNumber(input);
        if (paymetMethod == 1 || paymetMethod == 2)
            return true;
        System.out.println("주문 방식을 잘못 입력하셨습니다.\n");
        return false;
    }
}
