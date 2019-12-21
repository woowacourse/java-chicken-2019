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
    private static final List<Integer> orderedMenuCount = new ArrayList<>();
    private static final List<Integer> orderedMenuCost = new ArrayList<>();

    public Pay(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getTablePay() {
        return tablePay;
    }

    public void setMenus(String menu, int cost) {
        int index = orderedMenu.indexOf(menu);
        if(index != -1) {
            orderedMenuCount.set(index,orderedMenuCount.get(index)+1);
            orderedMenuCost.set(index,orderedMenuCost.get(index)+cost);
        } else {
            orderedMenu.add(menu);
            orderedMenuCount.add(1);
            orderedMenuCost.add(cost);
        }
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
        List<String> finalMenu = new ArrayList<>();
        for (int index = 0; index < orderedMenu.size(); index++) {
            String result = orderedMenu.get(index) + " " + orderedMenuCount.get(index) + " " + orderedMenuCost.get(index);
            finalMenu.add(result);
        }
        return finalMenu;
    }

    public void resetTable() {
        tablePay = 0;
        countMenu = 0;
        orderedMenu.clear();
    }
}
