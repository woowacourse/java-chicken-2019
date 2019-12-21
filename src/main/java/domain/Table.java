package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Table {
    private final int number;
    private List<Menu> menus;
    private int[] orderNumberArray;
    private int totalPrice;

    public Table(final int number) {
        this.number = number;
        this.totalPrice = 0;
        this.menus = new ArrayList<>();
        this.orderNumberArray = new int[23];
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void addMenuToTable(Menu menu, int menuNumber, int amountNumber) {
        for (int i = 0; i < amountNumber; i++) {
            menus.add(menu);
            orderNumberArray[menuNumber] += 1;
        }
    }

    public boolean tableHasMenu() {
        if (!menus.isEmpty()) {
            return true;
        }
        return false;
    }

    public int currentMenus() {
        for (int i = 0; i < menus.size(); i++) {
            String menuInfo = menus.get(i).toString();
            int order = Integer.parseInt(menuInfo.split("-")[0].trim());
            int orderCount = orderNumberArray[order];
            String orderName = menuInfo.split("-")[1].split(":")[0].trim();
            int orderPrice = Integer.parseInt(menuInfo.split(":")[1].split("원")[0].trim());
            System.out.println(orderName + "\t" + orderCount + "\t" + orderPrice);
            totalPrice += orderCount * orderPrice;
        }
        return totalPrice;
    }

}
