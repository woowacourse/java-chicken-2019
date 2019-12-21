package domain;

public enum Category {
    CHICKEN("치킨"),
    BEVERAGE("음료");

    private final String name;

    Category(final String name) {
        this.name = name;
    }

    public boolean isChicken() {
        return this == CHICKEN;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
