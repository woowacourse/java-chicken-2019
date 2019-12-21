package domain;

public class MenuNumber {
    private int number;

    public MenuNumber(int number) {
        validatePlus(number);
        this.number = number;
    }

    private void validatePlus(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("메뉴 번호는 음수가 될 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

}
