package domain;

import java.util.Objects;

public class MenuCount {
    private final static int MIN_COUNT = 1;
    private final static int MAX_COUNT = 99;
    private int menuCount;

    public MenuCount(String inputString) {
        int menuCount;
        try {
            menuCount = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("※ 숫자만 입력 가능합니다.");
        }
        if (isOutOfCountLimit(menuCount)) {
            throw new IllegalArgumentException(String.format("※ 메뉴는 %d개부터 %d개까지 주문 가능합니다.", MIN_COUNT, MAX_COUNT));
        }
        this.menuCount = menuCount;
    }

    private boolean isOutOfCountLimit(int menuCount) {
        return menuCount < MIN_COUNT || MAX_COUNT < menuCount;
    }

    public int get() {
        return menuCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuCount menuCount1 = (MenuCount) o;
        return menuCount == menuCount1.menuCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuCount);
    }
}

