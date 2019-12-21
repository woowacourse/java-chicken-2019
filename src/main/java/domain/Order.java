package domain;

import javafx.scene.control.Tab;

import java.util.List;

public class Order {
    public int tableNumber;
    public int menuCategory;
    public int menuCount;
    private final int MAX_ORDER_COUNT = 99;

    public Order(int newTableNumber, int newMenuCategory,int newMenuCount){
        tableNumber = newTableNumber;
        menuCategory = newMenuCategory;
        menuCount = newMenuCount;
    }
//    public boolean isFirstOrderTable(int newInputTable){
//        return tableNumber.contains(newInputTable);
//    }
//    public boolean isFirstMenuCategory(int newInputMenu) {
//        return menuCategory.contains(newInputMenu);
//    }
//    public boolean isOverCountNumber(int newInputMenuCategory,int newInputMenuCount){
//        return menuCount.get(menuCategory.indexOf(newInputMenuCategory)) + newInputMenuCount > MAX_ORDER_COUNT;
//    }


}
