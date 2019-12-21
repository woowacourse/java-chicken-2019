package domain;

import java.util.ArrayList;
import java.util.List;

import view.InputView;
import view.OutputView;


public class Order {
    private static final int MENU_NAME_INDEX= 0;
    private static final int MENU_QAUNTITY = 1;
    private static final int ORDER_TOTAL_PRICE = 2;
    private static final int MAX_QUANTITY = 99;
    private int tableNumber;
    private int menuNumber;
    private int menuQuantity;

    public Order(int tableNumber, int menuNumber, int quantity) {
        this.tableNumber = tableNumber;
        this.menuNumber = menuNumber;
        this.menuQuantity = quantity;
    }

    public boolean isTableNumber(int tableNumber) {
        if (this.tableNumber == tableNumber) {
            return true;
        }

        return false;
    }

    public boolean isMenuNumber(int menuNumber) {
        if (this.tableNumber == menuNumber) {
            return true;
        }

        return false;
    }

    public boolean isOverQuantity(int quantity) {
        if (this.menuQuantity + quantity > MAX_QUANTITY) {
            return true;
        }

        return false;
    }

    public String getInformation() {
        Menu menu = MenuRepository.search(this.menuNumber);
        String[] information = new String[3];

        information[MENU_NAME_INDEX] = menu.getMenuName();
        information[MENU_QAUNTITY] = Integer.toString(this.menuQuantity);
        information[ORDER_TOTAL_PRICE] = Integer.toString(this.menuQuantity  * menu.getPrice());

        return information[0] + " " + information[1] + " " + information[2];
    }
}
