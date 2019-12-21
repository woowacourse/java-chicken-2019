package domain;

public class Order {
    private int orderQuantity;
    private final Menu menu;

    public Order(int orderQuantity, Menu menu) {
        this.orderQuantity = orderQuantity;
        this.menu = menu;
    }

    public int getOrderQuantity() {
        return this.orderQuantity;
    }

    public final Menu getMenu() {
        return this.menu;
    }
}
