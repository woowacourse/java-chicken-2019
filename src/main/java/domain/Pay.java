package domain;

import java.util.ArrayList;
import java.util.List;

public class Pay {
    private int countMenu;
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
        countMenu++;
    }

    public List<String> getOrderedMenu() {
        return orderedMenu;
    }

}
