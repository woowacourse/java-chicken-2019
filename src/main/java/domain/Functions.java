package domain;

public enum Functions {
    REGISTER(1,"주문등록"),
    PAY(2,"결제하기"),
    EXIT(3,"프로그램 종료");

    private final int number;
    private final String message;

    Functions(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public int getNumber() {
        return number;
    }
}
