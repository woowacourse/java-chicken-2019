package domain;

public class Order {
    private final Table table;
    private final Menu menu;
    private final int quantity;

    public Order(final Table table, final Menu menu, final int quantity) {
        this.table = table;
        this.menu = menu;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return menu.getName() + " " + quantity + " " + this.totalPrice();
    }

    public boolean orderCheck(int number) {
        return table.toString().equals(Integer.toString(number));
    }

    public int totalPrice() {
        return menu.getPrice() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
