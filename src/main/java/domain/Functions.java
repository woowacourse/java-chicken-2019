package domain;

public enum Functions {
    REGISTER(1, "주문등록"),
    PAY(2, "결제하기"),
    EXIT(3, "프로그램 종료");

    private static final String NEW_LINE = "\n";
    private final int number;
    private final String message;

    Functions(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "메인 화면" + NEW_LINE
                + REGISTER.number + " - " + REGISTER.message + NEW_LINE
                + PAY.number + " - " + PAY.message + NEW_LINE
                + EXIT.number + " - " + EXIT.message + NEW_LINE;
    }
}
