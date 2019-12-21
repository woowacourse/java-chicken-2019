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
        if (menus.get(menu) != null) {
            menus.put(menu, menus.get(menu) + amount);
        }
        menus.put(menu, amount);
        return new Order(menus);
    }

    public Price PriceInfo() {
        Price price = new Price(ZERO);
        Iterator<Menu> menuIterator = menus.keySet().iterator();
        while (menuIterator.hasNext()) {
            Menu oneMenu = menuIterator.next();
            price = price.addPrice(oneMenu, menus.get(oneMenu));
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("메뉴  수량  금액");
        Iterator<Menu> menuIterator = menus.keySet().iterator();
        while (menuIterator.hasNext()) {
            Menu oneMenu = menuIterator.next();
            int onePrice = menus.get(oneMenu);
            sb.append("\n" + oneMenu.getName() + " " + onePrice + " " + oneMenu.getPrice() * onePrice);
        }
        String menuString = sb.toString();
        return menuString;
    }
}
