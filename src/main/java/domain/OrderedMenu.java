package domain;

import java.util.ArrayList;
import java.util.List;

public class OrderedMenu {
    private static final int SEVEN = 7;
    private Table table;
    private Menu menu;
    private int count;

    public OrderedMenu(Table table, Menu menu, int count) {
        this.table = table;
        this.menu = menu;
        this.count = count;
    }

    public int getMenuId(){
        return menu.getNumber();
    }

    public double sumOfEachMenu(){
        return menu.getPrice() * count;
    }

    public boolean isChicken(int menuNumber){
        List<Integer> chickenList = new ArrayList<>();
        for(int i=1; i<SEVEN; i++){
            chickenList.add(i);
        }
        return chickenList.contains(menuNumber);
    }

    @Override
    public String toString(){
        return menu.getName() + ", 수량 : " + count + " 가격 : " + menu.getPrice() * count;
    }

}
