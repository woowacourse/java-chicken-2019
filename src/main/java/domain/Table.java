package domain;

import java.util.LinkedList;
import java.util.List;

public class Table {
    private final int number;
    private List<Menu> menu = new LinkedList<>();

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

    public void addMenu(int type, int count) {
        for (int i = 0; i < count; i++) {
            menu.add(MenuRepository.menus().get(type));
        }
    }

    public List<Menu> getMenu() {
        return menu;
    }
}
