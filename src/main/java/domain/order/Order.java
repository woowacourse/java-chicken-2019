package domain.order;

import domain.menu.Menu;
import domain.menu.MenuRepository;

import java.util.HashMap;

public class Order {
    HashMap<Menu, Amount> order;

    public Order() {
        this.order = new HashMap<>();
    }

    public void add(int menuNumber, int menuAmount) {
        Menu menu = MenuRepository.findMenuBy(menuNumber);
        Amount amount = new Amount(menuAmount);

        order.put(menu, amount);
    }
}
