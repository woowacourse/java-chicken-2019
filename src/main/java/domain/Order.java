package domain;

public class Order {
    private int orderQuantity;
    private int menu;

    public Order(int orderQuantity, int menu) {
        this.orderQuantity = orderQuantity;
        this.menu = menu;
    }
}
