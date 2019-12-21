package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private final Map<MenuNumber, Integer> orderedMenuList = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public boolean isSameTableNumber(int tableNumber) {
        return number == tableNumber;
    }

    public void getOrderedMenu(MenuNumber menuNumber, MenuCount menuCount) {
        if (orderedMenuList.keySet().contains(menuNumber)) {
            int countSum = orderedMenuList.get(menuNumber) + menuCount.get();
            orderedMenuList.put(menuNumber, countSum);
            return;
        }
        orderedMenuList.put(menuNumber, menuCount.get());
    }

    public boolean isUnpaidTable() {
        return orderedMenuList.size() != 0;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
