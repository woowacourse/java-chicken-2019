package domain;

import java.util.List;
import java.util.ArrayList;

public class Table {
    private final int number;
    private static int orderedMenuNumber;
    private List<Menu> menus = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    public int getOrderedMenuNumber(){
        return orderedMenuNumber;
    }

    public boolean getTable(int tableNumber){
        if(tableNumber == number){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
