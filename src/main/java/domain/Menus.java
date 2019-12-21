package domain;

import java.util.HashMap;

public class Menus {
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
}
