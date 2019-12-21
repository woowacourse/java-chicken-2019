/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * Menu.java
 * Menu에 대한 정보를 담고있는 객체
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        21 Dec 2019
 *
 */

package domain;

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

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
