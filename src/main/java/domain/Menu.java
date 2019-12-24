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

    public int getPrice(int amount) {
        return amount * price;
    }

    public String getName() {
        return name;
    }

    public boolean isChicken() {
        return this.category.equals(CHICKEN);

    }


}
