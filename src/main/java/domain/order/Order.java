package domain.order;

import domain.Exception.MenuDoesNotExistExeption;
import domain.menu.Menu;

import java.util.HashMap;

public class Order {
    HashMap<Menu, Amount> order;

    public Order() {
        this.order = new HashMap<>();
    }

    public void add(Menu menu, int menuAmount) throws MenuDoesNotExistExeption {
        Amount amount = new Amount(menuAmount);

        order.put(menu, amount);
    }
}
