package domain;

public class Order {
    private int orderQuantity;
    private Menu menu;

    public Order(int orderQuantity, Menu menu) {
        this.orderQuantity = orderQuantity;
        this.menu = menu;
    }

    public int getOrderQuantity() {
        return this.orderQuantity;
    }

    public String getWhatMenu() {
        return menu.getName();
    }
}
