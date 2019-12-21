package domain;

public class Order {
    private final Menu menu;
    private final int amount;

    public Order(Menu menu, int amount) {
        this.menu = menu;
        this.amount = amount;
    }

    public int price()
    {
        return menu.price() * amount;
    }

    public String toString() {
        return menu.name() + ' ' + amount + ' ' + price();
    }
}
