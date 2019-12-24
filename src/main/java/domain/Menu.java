/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */
package domain;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 메뉴를 만드는 클래스입니다.
 * @since : 2019.12.23 월요일
 */
public class Menu {
    private static final String CHICKEN = "치킨";
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isChicken() {
        return category.getName().equals(CHICKEN);
    }
}
