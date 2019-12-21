package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Table {
    private final int number;
    private Map<Integer, Integer> orderMenu = new HashMap<Integer, Integer>();
    private boolean orderTF = false;

    public Table(final int number) {
        this.number = number;
    }

    public void addOrderMenu(int menuNumber, int quantityNumber) {
        int asIsQuantityNumber = 0;
        if (orderMenu.containsKey(menuNumber)) {
            asIsQuantityNumber = orderMenu.get(menuNumber);
        }
        orderMenu.put(menuNumber, asIsQuantityNumber + quantityNumber);
        orderTF = true;
    }

    public int getOrderMenuCount(int menuNumber) {
        int orderMenuCount = 0;
        if (orderMenu.containsKey(menuNumber)) {
            orderMenuCount = orderMenu.get(menuNumber);
        }
        return orderMenuCount;
    }

    public String orderMenuTotal() {
        TreeMap<Integer, Integer> orderMenuSort = new TreeMap<Integer, Integer>(orderMenu);
        StringBuilder orderMenus = new StringBuilder();
        for (int menu : orderMenuSort.keySet()) {
            Menu tableOrderMenu = MenuRepository.selectMenu(menu);
            orderMenus.append(tableOrderMenu.getName());
            orderMenus.append(" ");
            orderMenus.append(orderMenuSort.get(menu));
            orderMenus.append(" ");
            orderMenus.append(orderMenuSort.get(menu) * tableOrderMenu.getPrice());
            orderMenus.append("\n");
        }
        return orderMenus.toString();
    }

    public int orderPriceTotal() {
        int price = 0;
        int chickenCount = 0;
        for (int menu : orderMenu.keySet()) {
            Menu tableOrderMenu = MenuRepository.selectMenu(menu);
            price += orderMenu.get(menu) * tableOrderMenu.getPrice();
            chickenCount += orderMenu.get(menu) * tableOrderMenu.isChickenOneReturn();
        }
        return orderPriceCal(price, chickenCount);
    }

    private int orderPriceCal(int price, int chickenCount) {
        if (chickenCount >= 10) {
            price -= chickenCount / 10 * 10_000;
        }
        return price;
    }

    public void clearOrderMenu() {
        orderMenu.clear();
        orderTF = false;
    }

    public boolean getOrderTF() {
        return orderTF;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
