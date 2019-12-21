package domain;

public class Table {
    private static final int CASH_NUMBER = 2;
    private static final double DISCOUNT_RATE = 0.05;
    private final int number;
    private Menus menus;

    public Table(final int number) {
        this.number = number;
        this.menus = new Menus();
    }
    
    public boolean isTheTable(int number) {
        return this.number == number;
    }
    
    public void addMenu(int menuNumber, int count) {
        menus.addMenuByNumber(menuNumber, count);
    }
    
    public boolean isEmptyMenus() {
        return menus.isNull();
    }
    
    public String getMenusString() {
        return menus.toString();
    }
    
    public double getFinalPrice(int paymentNumber) {
        if (paymentNumber == CASH_NUMBER) {
            return menus.calculatePrice() * (1 - DISCOUNT_RATE);
        }
        
        return menus.calculatePrice();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
