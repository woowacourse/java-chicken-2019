package domain;

public class PayMethod {
    private static final int CASH = 2;

    private int payMethod;

    public PayMethod(int payMethod) {
        validatePayMethod(payMethod);
        this.payMethod = payMethod;
    }

    private void validatePayMethod(int payMethod) {
        if (!(payMethod == 1 || payMethod == 2)) {
            throw new IllegalArgumentException("1이나 2를 입력해주세요.");
        }
    }

    public boolean isCash() {
        return payMethod == CASH;
    }
}
