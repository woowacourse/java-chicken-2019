package domain;

import java.util.List;

public class Table {
    private final int number;
    private final int MAX_ORDER = 99;

    private List<Menu> menus;

    public Table(final int number) {
        System.out.println(number+" 테이블 생성됨");
        this.number = number;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public boolean isCorrectTable(int tableNumber) {
        return this.number == tableNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
