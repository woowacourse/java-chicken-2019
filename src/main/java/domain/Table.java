package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private final List<Menu> menus = new ArrayList<>();
    private final List<Integer> counts = new ArrayList<>();

    public static final int MENU_LIMIT = 99;

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

    /**
     * 테이블에 주문이 있는지 확인하는 메소드.
     * 주문이 있으면 true를 return한다.
     */
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

    public boolean hasMenu(Menu menu) {
        return menus.contains(menu);
    }
}
