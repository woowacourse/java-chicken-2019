package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {
    private int orderedMenu;
    private int quantity;

    public Order(int inputMenuNumber, int inputQuantity) {
        this.orderedMenu = inputMenuNumber;
        this.quantity = inputQuantity;
    }

    public int getOrderNumber() {
        return this.orderedMenu;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addQuantity(int addedQuantity) {
        this.quantity += addedQuantity;
    }

    public boolean isSameOrder(int inputMenuNumber) {
        return this.orderedMenu == inputMenuNumber;
    }


//    public void addOrderForTable(Order inputOrder) {
//        int inputMenuNumber = inputOrder.
//    }
//
//    public void getOrderForTable(int inputMenuNumber, int inputQuantityNumber) {
//        if (menuNumberAndQuantity.containsKey(inputMenuNumber)) {
//            menuNumberAndQuantity.put(inputMenuNumber, menuNumberAndQuantity.get(inputMenuNumber) + inputQuantityNumber);
//            return;
//        }
//        menuNumberAndQuantity.put(inputMenuNumber, inputQuantityNumber);
//    }
//
//    public Table getTable() {
//        return this.table;
//    }
//
//    public int getTableNumber() {
//        return this.table.getNumber();
//    }

}
