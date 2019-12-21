package domain;

import java.util.ArrayList;
import java.util.List;

import view.InputView;
import view.OutputView;


public class Order {
    private static final String name = "주문하기";
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

}
