package domain;

public class MainFeatureNumber {
    public static final int ORDER = 1;
    public static final int PAY = 2;
    public static final int EXIT = 3;
    private final int mainFeatureNumber;

    public MainFeatureNumber(String inputString) {
        int mainFeatureNumber;
        try {
            mainFeatureNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("※ 숫자만 입력 가능합니다.");
        }
        if (isNotExistMainFeatureNumber(mainFeatureNumber)) {
            throw new IllegalArgumentException("※ 1, 2, 3 중에서 입력 가능합니다.");
        }
        this.mainFeatureNumber = mainFeatureNumber;
    }

    private boolean isNotExistMainFeatureNumber(int mainFeatureNumber) {
        return !(mainFeatureNumber == ORDER || mainFeatureNumber == PAY || mainFeatureNumber == EXIT);
    }

    public boolean isOrder() {
        return mainFeatureNumber == ORDER;
    }

    public boolean isPay() {
        return mainFeatureNumber == PAY;
    }

    public boolean isExit() {
        return mainFeatureNumber == EXIT;
    }
}
