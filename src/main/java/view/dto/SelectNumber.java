package view.dto;

public class SelectNumber {
    private static final int MENU = 1;
    private static final int PAYMENT = 2;
    private static final int OFF = 3;

    private final int selectNumber;

    public SelectNumber(int selectNumber) {
        this.selectNumber = selectNumber;
    }

    public boolean isNotAllow() {
        return !isAllowNumber();
    }

    public boolean isAllowNumber() {
        return MENU == selectNumber || PAYMENT == selectNumber || OFF == selectNumber;
    }

    public boolean isNotOff() {
        return OFF != selectNumber;
    }

    public boolean isMenu() {
        return selectNumber == MENU;
    }
}
