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
}
