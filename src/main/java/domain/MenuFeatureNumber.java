package domain;

public class MenuFeatureNumber {
    public static final int ORDER = 1;
    public static final int PAY = 2;
    public static final int EXIT = 3;
    private final int menuFeatureNumber;

    public MenuFeatureNumber(String inputString) {
        int menuFeatureNumber;
        try {
            menuFeatureNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("※ 숫자만 입력 가능합니다.");
        }
        if (isNotExistMenuFeatureNumber(menuFeatureNumber)) {
            throw new IllegalArgumentException("※ 1, 2, 3 중에서 입력 가능합니다.");
        }
        this.menuFeatureNumber = menuFeatureNumber;
    }

    private boolean isNotExistMenuFeatureNumber(int menuFeatureNumber) {
        return !(menuFeatureNumber == ORDER || menuFeatureNumber == PAY || menuFeatureNumber == EXIT);
    }

    public boolean isOrder() {
        return menuFeatureNumber == ORDER;
    }

    public boolean isPay() {
        return menuFeatureNumber == PAY;
    }

    public boolean isExit() {
        return menuFeatureNumber == EXIT;
    }
}
