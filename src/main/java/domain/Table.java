package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private HashMap<Menu, Integer> orderMenu = new HashMap<>();
    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public HashMap<Menu, Integer> getOrderMenu() {
        return orderMenu;
    }

    public void order(Menu menu, int amount) {
        orderMenu.put(menu, amount);
    }
    
    public int getTotalMoney() {
        int sum = 0;
        
        for (Map.Entry<Menu, Integer> order : orderMenu.entrySet()) {
            sum += order.getKey().getPrice() * order.getValue();
        }
        return sum;
    }
}
