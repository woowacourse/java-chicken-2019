package domain;

import java.util.HashMap;

public class Menus {
    private static final int CHICKEN_DISCOUNT_PRICE = 10_000;
    private HashMap<Menu, Integer> menus;
    
    public Menus() {
        this.menus = new HashMap<>();
    }
    
    public void addMenuByNumber(int menuNumber, int count) {
        Menu menu = MenuRepository.getMenuByNumber(menuNumber);
        if (menus.containsKey(menu)) {
            menus.put(menu, menus.get(menu) + count);
            return;
        }
        
        menus.put(menu, count);
    }
    
    private int countChicken() {
        return menus.keySet().stream()
                .filter(Menu::isChicken)
                .mapToInt(menu -> menus.get(menu))
                .sum();
    }
    
    private int calculateRawPrice() {
        int price = 0;
        
        for (Menu menu : menus.keySet()) {
            price += menu.getPrice() * menus.get(menu);
        }
        
        return price;
    }
    
    public int calculatePrice() {
        return calculateRawPrice() 
                - CHICKEN_DISCOUNT_PRICE * countChicken();
    }
    
    public boolean isNull() {
        return menus.size() == 0;
    }
}
