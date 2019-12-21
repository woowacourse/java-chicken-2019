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

    public boolean isCorrectMenu(int menuNumber) {
        return this.number == menuNumber;
    }

    public boolean isChicken() {
        System.out.println(this.category);
        return this.category.equals("CHICKEN");
    }

    public String getNameTest() {
        return name;
    }

    protected int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
