package domain;

import domain.table.Table;

import java.util.Arrays;

import static util.ErrorMessage.INVALID_PAYMENT_METHOD_NUMBER;

public enum PayMethod {
    CARD(1) {
        @Override
        public int getResultPayAccount(Table table) {
            return super.getResultPayAccount(table);
        }
    },
    CASH(2) {
        private final static double CASH_DISCOUNT_RATE = 0.95;

        @Override
        public int getResultPayAccount(Table table) {
            int payMoney = super.getResultPayAccount(table);
            return (int) (payMoney * CASH_DISCOUNT_RATE);

        }
    };

    private int selectNumber;

    PayMethod(int selectNumber) {
        this.selectNumber = selectNumber;
    }

    public int getResultPayAccount(Table table) {
        return table.getTableCharge();
    }

    public static PayMethod findPayMethod(int selectNumber) {
        return Arrays.stream(PayMethod.values())
                .filter(s -> s.selectNumber == selectNumber)
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(INVALID_PAYMENT_METHOD_NUMBER);
                });
    }


}
