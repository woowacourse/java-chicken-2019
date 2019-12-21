package domain;

import java.util.ArrayList;
import java.util.List;

public class Pay {
    private int countMenu = 0;
    private final int tableNumber;
    private int tablePay = 0;
    private static final List<String> orderedMenu = new ArrayList<>();

    public Pay(int tableNumber) {
        this.tableNumber = tableNumber;
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

    public void plusCount() {
        countMenu += 1;
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
