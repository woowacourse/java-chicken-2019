package domain;

public class Order {
    private final Menu menu;
    private final int num;

    public Order(Menu menu, int num) {
        this.menu = menu;
        this.num = num;
    }

    public int price() {
        return menu.price() * num;
    }

    public String toString() {
        return menu.name() + ' ' + num + ' ' + price();
    }
}
