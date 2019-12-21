package domain;

public class Bill {
    private final String name;
    private int menuNumber = 0;
    private int price = 0;

    public Bill(String name) {
        this.name = name;
    }
    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public void setBill(int menuNumber, int price) {
        this.menuNumber += menuNumber;
        this.price += price;
    }
}
