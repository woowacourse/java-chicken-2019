package domain;

public class Order {
    private final Menu menu;
    private final int amount;

    public Order(Menu menu, int amount) {
        this.menu = menu;
        this.amount = amount;
    }

    public int getPrice() {
        return menu.getPrice() * amount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isChicken() {
        return menu.isChicken();
    }
}
