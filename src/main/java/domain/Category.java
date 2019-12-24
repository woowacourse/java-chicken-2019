/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package domain;

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

    public String getName() {
        return name;
    }
}
