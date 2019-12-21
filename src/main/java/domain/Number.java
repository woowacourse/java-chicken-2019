package domain;

public class Number {
    private int number;

    public Number(int number) {
        validatePlus(number);
        this.number = number;
    }

    private void validatePlus(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("번호는 음수가 될 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
