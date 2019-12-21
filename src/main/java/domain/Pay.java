package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pay {
    private int countMenu = 0;
    private final int tableNumber;
    private int tablePay = 0;
    private static final List<String> orderedMenu = new ArrayList<>();

    public Pay(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getTablePay() {
        return tablePay;
    }

    public void setMenus(String menu) {
        orderedMenu.add(menu);
    }

    public void setTablePay(int morePay) {
        tablePay += morePay;
    }

    public void plusCount(int menuNumber) {
        if (menuNumber < 7) {
            countMenu += 1;
        }
    }

    public int getCount() {
        return countMenu;
    }

    public List<String> getOrderedMenu() {
        return orderedMenu;
    }

    public void resetTable() {
        tablePay = 0;
        countMenu = 0;
        orderedMenu.clear();
    }
}
