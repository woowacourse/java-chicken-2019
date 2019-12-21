package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();
    private static final int MAX_AMOUNT = 99;

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

    public static boolean order(int tableNumber, Menu menu, int amount) {
        if (tables.get(tableNumber).getOrderMenu().containsKey(menu))
            amount += tables.get(tableNumber).getOrderMenu().get(menu);

        if (!checkAmount(tableNumber, amount))
            return false;

        tables.get(tableNumber).order(menu, amount);
        return true;
    }

    private static boolean checkAmount(int tableNumber, int amount) {
        if (amount > MAX_AMOUNT) {
            System.out.println("\n!!주문량이 너무 많습니다. 한 테이블은 99개가 최대입니다.");
            System.out.println("현재 주문량 : " + tables.get(tableNumber).getTotalAmount());
            return false;
        }
        return true;
    }

    public HashMap<Menu, Integer> getOrderMenuList(int tableNumber) {
        return tables.get(tableNumber).getOrderMenu();
    }
}
