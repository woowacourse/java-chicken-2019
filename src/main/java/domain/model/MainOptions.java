package domain.model;

public enum MainOptions {
    NONE(-1, "초기상태"),
    ADD_ORDER(1, "주문등록"),
    PAYMENT(2, "결제하기"),
    EXIT(3, "종료하기");

    private final int optionNumber;
    private final String description;

    MainOptions(int optionNumber, String description) {
        this.optionNumber = optionNumber;
        this.description = description;
    }

    @Override
    public String toString() {
        return optionNumber + " - " + description;
    }

    public boolean isStop() {
        return this == EXIT;
    }
}
