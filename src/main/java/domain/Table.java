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

    public int getNumber() {
        return number;
    }

    public HashMap<Menu, Integer> getOrderMenu() {
        return orderMenu;
    }

    public void order(Menu menu, int amount) {
        orderMenu.put(menu, amount);
    }
    
    public int getTotalAmount() {
        int sum = 0;
        
        for (Map.Entry<Menu, Integer> order : orderMenu.entrySet()) {
            sum += order.getValue();
        }
        return sum;
    }

    public int getTotalMoney() {
        int sum = 0;
        
        for (Map.Entry<Menu, Integer> order : orderMenu.entrySet()) {
            sum += order.getKey().getPrice() * order.getValue();
        }
        return chickenDiscount(sum);
    }

    public int chickenDiscount(int sum) {
        int chicken = 0;

        for (Map.Entry<Menu, Integer> order : orderMenu.entrySet()) {
            if (order.getKey().getCategory().equals("치킨")) {
                chicken += order.getValue() / 10;
            }
        }
        
        return sum - chicken * 10000;
    }
}
