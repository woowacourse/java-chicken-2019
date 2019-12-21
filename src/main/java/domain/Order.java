package domain;

public class Order {
    private final Table table;
    private Menus menus;

    public Order(Table table, Menus menus) {
        this.table = table;
        this.menus = menus;
    }

    public boolean isTableNumber(int tableNumber) {
        return table.isNumber(tableNumber);
    }
}
