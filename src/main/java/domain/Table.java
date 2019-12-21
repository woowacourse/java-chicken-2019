package domain;

import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private List<OrderedMenu> menuList;

    public Table(final int number) {
        this.number = number;
        menuList = new ArrayList<OrderedMenu>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getTableNumber(){
        return number;
    }

    public void addMenu(OrderedMenu menu) {
        menuList.add(menu);
    }

    public boolean equals(int tableNumber) {
        if (number == tableNumber) {
            return true;
        }
        return false;
    }

    public void printOrderedMenu() {
        OutputView.printOrderedMenu(menuList);
    }

    public int getSumOfPrice() {
        int price = 0;
        for (OrderedMenu menu : menuList) {
            price += menu.multiplyMenuPriceAndAuantity();
        }
        return price;
    }

    public int countTotalChicken(){
        int count = 0;
        for(OrderedMenu m : menuList){
            count += m.countChicken();
        }
        return count;
    }

    public void removeMenu(){
        menuList = new ArrayList<OrderedMenu>();
    }
}
