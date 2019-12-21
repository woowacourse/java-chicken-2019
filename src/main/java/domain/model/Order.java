package domain.model;

public class Order {
    private static final String ORDER_FORMAT = "%s - %d개, %d원";
    private Menu menu;
    private int count;

    public Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public int getPrice() {
        return menu.getPrice() * count;
    }

    @Override
    public String toString() {
        return String.format(ORDER_FORMAT, menu.getName(), count, getPrice());
    }
}
