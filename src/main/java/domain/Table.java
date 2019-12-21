package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private List<TableMenu> tableMenus = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    public void addMenu(Menu menu, int count) {
        tableMenus.add(new TableMenu(menu, count));
    }

    public int calculateTablePrice() {
        return tableMenus.stream().mapToInt(TableMenu::calculateMoney).sum();
    }

    public boolean hasOrder() {
        return tableMenus.isEmpty();
    }

    public void initTableMenu() {
        tableMenus = new ArrayList<>();
    }

    public boolean isSameTable(int tableNumber) {
        return number == tableNumber;
    }

    public int getNumber() {
        return number;
    }

    public List<TableMenu> getTableMenus() {
        return tableMenus;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
