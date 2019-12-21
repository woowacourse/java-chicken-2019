package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderedMenu {
    private static final int SEVEN = 7;
    private static final int MAX_ORDER = 99;
    private Table table;
    private Menu menu;
    private int count;

    public OrderedMenu(Table table, Menu menu, int count) {
        this.table = table;
        this.menu = menu;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public boolean canOrder(int howMany) {
        return count + howMany <= MAX_ORDER;
    }

    public int getMenuId() {
        return menu.getNumber();
    }

    public double sumOfEachMenu() {
        return menu.getPrice() * count;
    }

    public boolean isChicken(int menuNumber) {
        List<Integer> chickenList = new ArrayList<>();
        for (int i = 1; i < SEVEN; i++) {
            chickenList.add(i);
        }
        return chickenList.contains(menuNumber);
    }

    public void addJustCount(int howMany) {
        count += howMany;
    }

    @Override
    public String toString() {
        return menu.getName() + ", 수량 : " + count + " 가격 : " + menu.getPrice() * count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderedMenu)) return false;
        OrderedMenu that = (OrderedMenu) o;
        return table.equals(that.table) &&
                menu.equals(that.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, menu);
    }
}
