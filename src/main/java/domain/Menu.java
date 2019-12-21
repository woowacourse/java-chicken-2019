package domain;

public class Menu {

    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu( final int number, final String name, final Category category, final int price ) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public boolean isEqual( int menuNumber ) {
        return this.number == menuNumber;
    }

    public int menuNumber() {
        return getNumber();
    }

    private int getNumber() {
        return this.number;
    }

    public int getPrice( int quantity ) {
        return price * quantity;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
