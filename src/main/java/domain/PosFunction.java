package domain;

import java.util.Arrays;

public enum PosFunction {
    ORDER_REGISTRATION(1, "주문등록"),
    PAYMENT(2, "결제하기"),
    EXIT(3, "프로그램 종료");

    private int code;
    private String korean;

    PosFunction(int code, String korean) {
        this.code = code;
        this.korean = korean;
    }

    public static PosFunction of(int code) {
        return Arrays.stream(PosFunction.values())
            .filter(posFunction -> posFunction.code == code)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Pos 기능번호입니다."));
    }

    public int getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.korean;
    }
}
