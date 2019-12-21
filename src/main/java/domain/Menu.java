package domain;

public class Menu {
    private static final int CHICKEN_DISCOUNT = 10000;
    private static final int NO_DISCOUNT = 0;

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

    public Boolean isMatchingMenu(int menuNumber) {
        return this.number == menuNumber;
    }

    public String toString(int quantity) {
        return new StringBuffer(name)
                .append(" ")
                .append(quantity)
                .append(" ")
                .append(actualPrice(quantity))
                .toString();
    }

    private int discountPrice() {
        if (this.category == Category.CHICKEN) {
            return CHICKEN_DISCOUNT;
        }
        return NO_DISCOUNT;
    }

    private int actualPrice(int quantity) {
        return price * quantity - (quantity / 10) * discountPrice();
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
