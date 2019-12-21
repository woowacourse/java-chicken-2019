package domain;

public class Payment {
    private final int num;
    public Payment(int num) {
        if ((num != 1) && (num != 2)) {
            throw new IllegalArgumentException("결제 수단은 1,2번 중에서 가능합니다.");
        }
        this.num = num;
    }

    public int num() {
        return num;
    }

    public boolean isCash() {
        return num == 2;
    }
}
