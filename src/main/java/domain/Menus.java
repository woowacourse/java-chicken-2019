package domain;

import java.util.HashMap;

import view.Validator;

public class Menus {
    private static final int CHICKEN_DISCOUNT_PRICE = 10_000;
    private static final int PER_DISCOUNT_NUMBER = 10;
    private HashMap<Menu, Integer> menus;
    
    public Menus() {
        this.menus = new HashMap<>();
    }
    
    public void addMenuByNumber(int menuNumber, int count) {
        Menu menu = MenuRepository.getMenuByNumber(menuNumber);
        Validator.validateMenuMaxCount(count);
        
        if (menus.containsKey(menu)) {
            Validator.validateMenuMaxCount(menus.get(menu) + count);
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
        int discountNumber = countChicken() / PER_DISCOUNT_NUMBER;
        return calculateRawPrice() 
                - CHICKEN_DISCOUNT_PRICE * discountNumber;
    }
    
    public boolean isNull() {
        return menus.size() == 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Menu menu : menus.keySet()) {
            sb.append(menu.getName() + " ");
            sb.append(menus.get(menu) + " ");
            sb.append(menu.getPrice() * menus.get(menu) + "\n");
        }
        return sb.toString();
    }
}
