package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private static final List<Menu> menus = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return number;
    }

    public int getTableMenuCount() {
        return menus.size();
    }

    public void addMenu(Menu menu){
        menus.add(menu);
    }

    public int getChickenCount() {
        int count = 0;
        for (int i = 0; i < menus.size(); i++) {
            if (menus.get(i).getCategory() == Category.CHICKEN)
                count++;
        }
        return count;
    }

    public int getTotalPrice(){
        int totalPrice = 0;
        for (int i = 0; i < menus.size(); i++) {
            totalPrice += menus.get(i).getPrice();
        }
        return totalPrice;
    }
}
