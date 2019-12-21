/*
 * @(#)Menu.java        0.2 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

package domain.menu;

public class Menu {
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

    public boolean isSelectedMenu(final int menuNumber) {
        return this.number == menuNumber;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isChicken() {
        return category.isChicken();
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
