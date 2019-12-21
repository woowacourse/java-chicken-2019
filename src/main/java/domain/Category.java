package domain;

/**
 * 치킨의 타입을 의미하는 열거형
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-21
 */
public enum Category {
    CHICKEN("치킨"),
    BEVERAGE("음료");

    private final String name;

    Category(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
