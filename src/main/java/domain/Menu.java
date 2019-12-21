package domain;

public class Menu {
    private static final int CHICKEN_NUMBER = 6;
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
    
    public boolean isTheMenu(int number) {
        return this.number == number;
    }
    
    public boolean isChicken() {
        return this.number <= CHICKEN_NUMBER;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
