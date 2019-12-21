package exception;

public class PosNumber {
    private int number = 0;

    private final int NULL_VALUE = 0;
    private final int MAX_NUMBER = 3;
    private static final int OPTION_ONE = 1;
    private static final int OPTION_TWO = 2;
    private static final int OPTION_THREE = 3;

    public PosNumber(int number) {
        if (number == NULL_VALUE) {
            throw new IllegalArgumentException("값을 입력하지 않았습니다. 값을 입력해주세요.");
        }
        if (number > MAX_NUMBER) {
            throw new IllegalArgumentException("1 부터 3 사이의 Option 을 선택해주세요.");
        }
        this.number = number;
    }

    public boolean isOptionOne() {
        return number == OPTION_ONE;
    }

    public boolean isOptionTwo() {
        return number == OPTION_TWO;
    }

    public boolean isOptionThree() {
        return number == OPTION_THREE;
    }
}
