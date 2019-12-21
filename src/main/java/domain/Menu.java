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

    public Boolean isMatchingMenu(int menuNumber) {
        return this.number == menuNumber;
    }

    public String getNameAndTotalPrice(int quantity) {
        return new StringBuffer(name)
                .append(" ")
                .append(quantity)
                .append(" ")
                .append(price * quantity)
                .toString();
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
