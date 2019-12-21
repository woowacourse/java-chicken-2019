package domain;

import java.util.HashMap;
import java.util.Iterator;

public class Order {
    private static final int ZERO = 0;
    private final HashMap<Menu, Integer> menus;

    public Order(HashMap<Menu, Integer> menus) {
        this.menus = menus;
    }

    public Order addNewOrder(Menu menu, int amount) {
        if(menus.get(menu) != null) {
            menus.put(menu, menus.get(menu)+amount);
            System.out.println("새 메뉴 "+menu.getNameTest()+" "+menus.get(menu));
        }
        menus.put(menu, amount);
        return new Order(menus);
    }

    public boolean isEmpty() {
        return this.menus.isEmpty();
    }

    public Price PriceInfo() {
        Price price = new Price(ZERO);
        Iterator<Menu> menuIterator = menus.keySet().iterator();
        while(menuIterator.hasNext()) {
            Menu oneMenu = menuIterator.next();
            price = price.addPrice(oneMenu, menus.get(oneMenu));
        }
        return price;
    }
}
