package domain;

public class Function {
    private static final int REGISTER_ORDER_VALUE = 1;
    private static final int PAYMENT_VALUE = 2;
    private static final int TERMINATION_VALUE = 3;

    private int select;

    public Function(int select) {
        if ((select != REGISTER_ORDER_VALUE) && (select != PAYMENT_VALUE) && (select != TERMINATION_VALUE)) {
            throw new IllegalArgumentException("없는 기능입니다. 1, 2, 3 중 선택해주세요.");
        }
        this.select = select;
    }

    public boolean isTermination() {
        return select == TERMINATION_VALUE;
    }

    public boolean isRegisterOrder() {
        return select == REGISTER_ORDER_VALUE;
    }

}
