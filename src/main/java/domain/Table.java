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

    public String orderMenuTotal() {
        TreeMap<Integer, Integer> orderMenuSort = new TreeMap<Integer, Integer>(orderMenu);
        StringBuilder orderMenus = new StringBuilder();
        for (int menu : orderMenuSort.keySet()) {
            Menu orderMenu = MenuRepository.selectMenu(menu);
            orderMenus.append(orderMenu.getName());
            orderMenus.append(" ");
            orderMenus.append(orderMenuSort.get(menu));
            orderMenus.append(" ");
            orderMenus.append(orderMenuSort.get(menu) * orderMenu.getPrice());
            orderMenus.append("\n");
        }
        return orderMenus.toString();
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
