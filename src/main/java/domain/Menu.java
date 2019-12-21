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

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    public String getOrderString(int orderAmount) {
        return this.name + " " + orderAmount + " " + (this.price * orderAmount) + "\n";
    }

    public int getAmountPrice(int orderAmount) {
        return orderAmount * this.price;
    }
}
