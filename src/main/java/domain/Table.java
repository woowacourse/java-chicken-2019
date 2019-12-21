package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private final List<Menu> menus = new ArrayList<>();
    private final List<Integer> counts = new ArrayList<>();

    private static final int MENU_LIMIT = 99;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void addMenus(Menu menu, int count) {
        menus.add(menu);
        counts.add(count);
    }

    public boolean isOrdered() {
        return !menus.isEmpty();
    }

    public boolean isSame(int number) {
        return this.number == number;
    }

    public void printOrderList() {
        for (int i = 0 ; i < menus.size() ; i++) {
            String name = menus.get(i).getName();
            int count = counts.get(i);
            int sum = menus.get(i).getPrice() * count;
            System.out.println(name + '\t'+ count + '\t' + sum);
        }
    }
}
