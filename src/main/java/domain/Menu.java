package domain;

import static domain.Category.CHICKEN;

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

    public boolean isEqualNumber(int inputNumber) {
        return this.number == inputNumber;
    }

    public int getPrice(int amount) {   //TODO 현재 종류 할인이 아닌 단일 메뉴 할인이 되어있음
        if (category.equals(CHICKEN) && amount >= 10) {
            return price * amount - (10000 * amount/10);
        }
        return amount * price;
    }

    public String getName() {
        return name;
    }


}
