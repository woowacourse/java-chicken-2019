package domain;

public class Bill {
    private final String name;
    private int menuNumber;
    private int price;

    public Bill(String name, int menuNumber, int price) {
        this.name = name;
        this.menuNumber = menuNumber;
        this.price = price;
    }
    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return this.name;
    }

    public int getMenuNumber() {
        return this.menuNumber;
    }

    public int getPrice() {
        return this.price;
    }

    public void setBill(int menuNumber, int price) {
        this.menuNumber += menuNumber;
        this.price += price;
    }
}
