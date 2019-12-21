package domain.reserved;

import domain.Capacity;
import domain.Category;
import domain.Menu;

/*예약된 메뉴 하나를 가지고 있다.*/
public class OrderedMenu extends Menu {
    private final Capacity capacity;

    public OrderedMenu(Menu menu) {
        super(menu.getNumber(), menu.getName(), menu.getCategory(), menu.getPrice());
        this.capacity = new Capacity(0);
    }

    public OrderedMenu(Menu menu, int capacity) {
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

    public int getTotalPrice() {
        return getPrice() * getCapacity().getCapacity();
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public int calcuratePrice(OrderedMenu otherOrderedMenu) {
        return otherOrderedMenu.getPrice() + this.getPrice();
    }

    public boolean isChicken() {
        return getCategory().isChicken();
    }

    public int calcurateCapacity(OrderedMenu otherOrderedMenu) {
        return otherOrderedMenu.getCapacity().getCapacity()
                + this.getCapacity().getCapacity();
    }
}
