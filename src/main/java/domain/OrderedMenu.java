package domain;

public class OrderedMenu {
    private Menu menu;
    private int menuQuantity;

    public OrderedMenu(Menu menu, int menuQuantity) {
        this.menu = menu;
        this.menuQuantity = menuQuantity;
    }

    public String toString() {
        return menu.getName() + " " + menuQuantity + " " + menu.getPrice();
    }

    public int multiplyMenuPriceAndAuantity() {
        return menu.getPrice() * menuQuantity;
    }

}
