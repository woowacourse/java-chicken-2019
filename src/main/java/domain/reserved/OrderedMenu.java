package domain.reserved;

import domain.Capacity;
import domain.Menu;

public class OrderedMenu extends Menu {
    private static final int ZERO = 0;
    private final Capacity capacity;

    OrderedMenu(Menu menu, int capacity) {
        super(menu.getNumber(), menu.getName(), menu.getCategory(), menu.getPrice());
        this.capacity = new Capacity(capacity);
    }

    public static OrderedMenu createMenu(Menu menu, int capacity) {
        return new OrderedMenu(menu, capacity);
    }

    public int checkPossibleOrder(int orderCapacity) {
        if (capacity.isPossibleOrder(orderCapacity)) {
            throw new IllegalArgumentException();
        }
        return orderCapacity;
    }

    int getTotalPrice() {
        return getPrice() * getCapacity().getCapacity();
    }

    public Capacity getCapacity() {
        return capacity;
    }

    boolean isChicken() {
        return getCategory().isChicken();
    }
}
