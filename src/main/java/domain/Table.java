package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private final int number;
    private Map<Menu, Integer> orderedList;


    public Table(final int number) {
        this.number = number;
        orderedList = new HashMap<>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return number;
    }

    public void order(Menu menu, int menuCount) {
        if (orderedList.containsKey(menu)) {
            int remainCount = orderedList.get(menu);
            orderedList.remove(menu, menuCount);
            orderedList.put(menu, remainCount + menuCount);
            return;
        }
        orderedList.put(menu, menuCount);
    }

    public boolean canOrder(Menu menu, int menuCount) {
        int totalCount = 0;

        if (orderedList.containsKey(menu)) {
            totalCount += orderedList.get(menu);
        }
        totalCount += menuCount;

        if (totalCount > Order.MAX_COUNT) {
            return false;
        }
        return true;
    }


}
