package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private List<OrderedMenu> menuList;

    public Table(final int number) {
        this.number = number;
        menuList = new ArrayList<OrderedMenu>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void addMenu(OrderedMenu menu){
        menuList.add(menu);
    }

    public boolean equals(int tableNumber){
        if(number == tableNumber){
            return true;
        }
        return false;
    }
}
