package domain;

public class Order extends MenuRepository {
    private Menu menu;
    private int quantity;

    public Order(Menu inputMenu, int inputQuantity) {
        this.menu = inputMenu;
        quantity = inputQuantity;
    }

    public int getOrderNumber() {
        return menu.getNumber();
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addQuantity(int addedQuantity) {
        this.quantity += addedQuantity;
    }

    public boolean isSameOrder(int inputMenuNumber) {
        return menu.getNumber() == inputMenuNumber;
    }

}
