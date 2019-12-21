package domain.order;

import domain.menu.Menu;

import java.util.HashMap;

public class Order {
    HashMap<Menu, Amount> order = new HashMap<>();

    public Order(HashMap<Menu, Amount> order) {
        this.order = order;
    }
}
