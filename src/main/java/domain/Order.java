package domain;

public class Order {
    private Table table;
    private Menu menu;
    private int quantity;

    public Order(Table table, Menu menu, int quantity) {
        this.table = table;
        this.menu = menu;
        this.quantity = quantity;
    }

    public int price() {
        return menu.getPrice() * quantity;
    }

    public int countChicken() {
        if (menu.isChicken()) {
            return quantity;
        }
        return 0;
    }

    @Override
    public String toString() {
        return menu.getName() + " " + quantity + " " + menu.getPrice();
    }
}
