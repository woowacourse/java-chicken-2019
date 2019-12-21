package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static void order(int tableNumber, Menu menu, int amount) {
        if (tables.get(tableNumber).getOrderMenu().containsKey(menu))
            amount += tables.get(tableNumber).getOrderMenu().get(menu);
        tables.get(tableNumber).order(menu, amount);
    }

    public HashMap<Menu, Integer> getOrderMenuList(int tableNumber) {
        return tables.get(tableNumber).getOrderMenu();
    }

    public static int getTotalMoney(int tableNumber) {
        HashMap<Menu, Integer> orderMenu = tables.get(tableNumber).getOrderMenu();
        int sum = 0;
        
        for (Map.Entry<Menu, Integer> order : orderMenu.entrySet()) {
            sum += order.getKey().getPrice() * order.getValue();
        }
        return sum;
    }
}
