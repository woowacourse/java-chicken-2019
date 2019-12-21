package domain;

import java.util.List;
import java.util.ArrayList;

public class Table {
    private final int number;
    private static int orderedMenuNumber;
    private List<Menu> menus = new ArrayList<>();
    private List<Integer> order = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    public int getOrderedMenuNumber(){
        return orderedMenuNumber;
    }

    public int getTableNumber(){
        return this.number;
    }

    public void addOrder(Menu menu, int order){
        this.menus.add(menu);
        this.order.add(order);
        orderedMenuNumber += order;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
