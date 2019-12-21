package domain;

import java.util.Objects;

public class MenuNumber {
    private final int menuNumber;

    public MenuNumber(String inputString) {
        int menuNumber;
        try {
            menuNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("※ 숫자만 입력 가능합니다.");
        }
        if (MenuRepository.doesNotExistMenuNumber(menuNumber)) {
            throw new IllegalArgumentException("※ 존재하는 메뉴 번호 중 1개만 입력 가능합니다.");
        }
        this.menuNumber = menuNumber;
    }

    public int get() {
        return menuNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuNumber that = (MenuNumber) o;
        return menuNumber == that.menuNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuNumber);
    }
}
