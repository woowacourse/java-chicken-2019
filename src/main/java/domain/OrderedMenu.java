package domain;

public class OrderedMenu {
    private final static int NO_CHICKEN = 0;
    private Menu menu;
    private int menuQuantity;

    public OrderedMenu(Menu menu, int menuQuantity) {
        this.menu = menu;
        this.menuQuantity = menuQuantity;
    }

    public String toString() {
        return menu.getName() + " " + menuQuantity + " " + menu.getPrice();
    }

    public int multiplyMenuPriceAndAuantity() {
        return menu.getPrice() * menuQuantity;
    }

    public int countChicken(){
       if(menu.isChicken()){
           return menuQuantity;
       }
       return NO_CHICKEN;
    }

}
